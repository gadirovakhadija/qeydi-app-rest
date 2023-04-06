package org.example.controller;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.service.UserControlServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRestController {
    @Autowired
    private UserControlServiceInter userControlService;

    @GetMapping("/users")
    private ResponseEntity<ResponseDTO> getUsers(
            @RequestBody UserDTO userDTO
    ) {
        return userControlService.getUsers(userDTO);
    }

    @GetMapping("/users/{id}")
    private ResponseEntity<ResponseDTO> getUser(
            @PathVariable("id") int id
    ) {
        return userControlService.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    private ResponseEntity<ResponseDTO> deleteUser(
            @PathVariable("id") int id
    ) {
        return userControlService.deleteUser(id);
    }

    @PutMapping("/registration")
    private ResponseEntity<String> registerUser(
            @RequestBody UserDTO userDTO
    ) {
        return userControlService.updateUser(userDTO);
    }

    @PostMapping("/reset")
    private ResponseEntity<String> reset(
            @RequestBody UserDTO userDTO
    ) {
        return userControlService.reset(userDTO);
    }


}
