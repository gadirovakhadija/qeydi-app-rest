package org.example.controller;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.service.UserControlServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionRestController {
    @Autowired
    private UserControlServiceInter userControlService;

    @PutMapping("/registration")
    private ResponseEntity<ResponseDTO> registerUser(
            @RequestBody UserDTO userDTO
    ) {
        return ResponseEntity.ok(userControlService.updateUser(userDTO));
    }


    @PutMapping("/reset")
    private ResponseEntity<ResponseDTO> reset(
            @RequestBody UserDTO userDTO
    ) {
        return ResponseEntity.ok(userControlService.reset(userDTO));
    }
}
