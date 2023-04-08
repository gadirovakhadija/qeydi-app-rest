package org.example.dao;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    User findByEmail(String email);

    List<User> findAll();

    User findById(int id);

    void deleteUserById(int id);
}
