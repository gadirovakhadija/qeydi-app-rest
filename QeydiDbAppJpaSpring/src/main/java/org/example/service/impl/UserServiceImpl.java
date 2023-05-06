package org.example.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.repo.UserRepository;
import org.example.repo.UserRepositoryCustom;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userRepoImpl")
    UserRepositoryCustom userRepoCust;

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAll(String name, String surname, String email) {
        return userRepoCust.getAll(name, surname, email);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public int findIdByEmail(String email) {
        return findByEmail(email).getId();
    }

    @Override
    public void updateUser(User u) {
        User user = userRepo.findById(u.getId());
        user.setName(u.getName());
        user.setSurname(u.getSurname());
        user.setAge(u.getAge());
        user.setUniversity(u.getUniversity());
        user.setPoint(u.getPoint());
        user.setExperience(u.getExperience());
        user.setTeachwayId(u.getTeachwayId());
        user.setSubjectId(u.getSubjectId());
        user.setCode(u.getCode());
        user.setCost(u.getCost());

        userRepo.save(user);
    }


    @Override
    public void deleteUserById(int id) {
        userRepo.deleteUserById(id);
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();
    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        User user = findByEmail(email);

        BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
        if (!rs.verified) {
            return null;
        }
        return user;

    }

    @Override
    public int findIdByEmailAndPassword(String email, String password) {

        User user = findUserByEmailAndPassword(email, password);
        return user.getId();

    }

    @Override
    public void addUser(User u) {

//        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        userRepo.save(u);
    }

    @Override
    public void updatePassword(User u) {

        User user = userRepo.findById(u.getId());
        user.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        userRepo.save(user);

    }

    @Override
    public List<User> findByTeachway(String teachway) {
        return userRepoCust.getUsersByTeachway(teachway);
    }

    @Override
    public List<User> findBySubject(String subject) {
        return userRepoCust.getUsersBySubject(subject);
    }


}
