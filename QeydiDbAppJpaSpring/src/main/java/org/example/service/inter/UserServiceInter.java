package org.example.service.inter;

import org.example.entity.User;

import java.util.List;

public interface UserServiceInter {

    List<User> getAll(String name, String surname, String email);
    List<User> findAll();
    User findByEmail(String email);
    User findById(int id);
    int findIdByEmail(String email);
    void updateUser(User u);

    void deleteUserById(int id);
    User findUserByEmailAndPassword(String email, String password);

    int findIdByEmailAndPassword(String email, String password);

    void addUser(User u);

    void updatePassword(User u);




}
