package org.example.service;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserControlServiceInter {
    ResponseEntity<ResponseDTO> getUsers(UserDTO userDTO);
    ResponseEntity<ResponseDTO> getUser(int id);
    ResponseEntity<ResponseDTO> deleteUser(int id);
    ResponseEntity<String> updateUser(UserDTO userDTO);
    ResponseEntity<String> signUp(UserDTO userDTO);
    ResponseEntity<String> reset(UserDTO userDTO);
}
