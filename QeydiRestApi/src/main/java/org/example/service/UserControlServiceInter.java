package org.example.service;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserControlServiceInter {
    List<ResponseDTO> getUsers(UserDTO userDTO);
    ResponseDTO getUser(int id);
    ResponseDTO deleteUser(int id);
    String updateUser(UserDTO userDTO);
    ResponseEntity<String> signUp(UserDTO userDTO);
    ResponseEntity<String> reset(UserDTO userDTO);
    List<User> findUsersByTeachway(String teachway);
    List<User> findUsersBySubject(String subject);
}
