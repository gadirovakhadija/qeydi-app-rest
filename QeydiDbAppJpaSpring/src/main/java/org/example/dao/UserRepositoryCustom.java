package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
    public List<User> getAll(String name, String surname, String email);
    public List<User> getUsersByTeachwayName(String teachwayName);

}
