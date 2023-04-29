package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.example.entity.Teachway;
import org.example.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userRepoImpl")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Cacheable("users")
    public List<User> getAll(String name, String surname, String email) {


        String jpql = "SELECT u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (email != null && !email.trim().isEmpty()) {
            jpql += " and u.email=:email ";
        }

        Query query = entityManager.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (email != null && !email.trim().isEmpty()) {
            query.setParameter("email", email);
        }

        return query.getResultList();
    }
    public List<User> searchTeachway(String searchTerm) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate searchPredicate = builder.like(
                builder.lower(root.get("teachway")),
                "%" + searchTerm.toLowerCase() + "%"
        );

        query.where(searchPredicate);

        return entityManager.createQuery(query).getResultList();
    }

   @Override
    public List<User> getUsersByTeachwayName(String teachwayName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        Join<User, Teachway> teachwayJoin = userRoot.join("teachway", JoinType.LEFT);

        query.select(userRoot)
                .distinct(true)
                .orderBy(builder.asc(userRoot.get("id")));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.like(builder.lower(teachwayJoin.get("teachway")), "%" + teachwayName.toLowerCase() + "%"));

        Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
        Predicate finalPredicate = builder.and(predicatesArray);
        query.where(finalPredicate);

        List<User> users = entityManager.createQuery(query)
                .getResultList();

        return users;
    }



}
