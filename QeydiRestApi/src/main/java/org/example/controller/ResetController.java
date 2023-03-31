package org.example.controller;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetController {
    @Autowired
    private UserServiceInter userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/reset")
    public ResponseEntity<String> reset(
            @RequestBody UserDTO userDTO
    ){
        if (userService.findUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()) == null)
            return new ResponseEntity<>("Information isn't correct", HttpStatus.BAD_REQUEST);

        User user = userService.findByEmail(userDTO.getEmail());

        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return new ResponseEntity<>("User successfully registered !", HttpStatus.CREATED);
    }
}
