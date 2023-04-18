package org.example.service;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserControlServiceInter {
    List<ResponseDTO> getUsers();

    ResponseDTO getUser(int id);

    ResponseDTO deleteUser(int id);

    ResponseDTO updateUser(UserDTO userDTO);

    ResponseDTO signUp(UserDTO userDTO);

    ResponseDTO reset(UserDTO userDTO);

    List<User> findUsersByTeachway(String teachway);

    List<User> findUsersBySubject(String subject);
}
