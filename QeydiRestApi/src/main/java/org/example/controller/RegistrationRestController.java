package org.example.controller;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRestController {

    @Autowired
    private UserServiceInter userService;

    @PutMapping("/registration")
    public ResponseEntity<String> registerUser(
            @RequestBody UserDTO userDTO
    ) {
        if (userService.findUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()) == null)
            return new ResponseEntity<>("Information isn't correct", HttpStatus.BAD_REQUEST);

        User user = userService.findByEmail(userDTO.getEmail());

        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAge(userDTO.getAge());
        user.setUniversity(userDTO.getUniversity());
        user.setPoint(userDTO.getPoint());
        user.setExperience(userDTO.getExperience());
        user.setTeachwayId(userDTO.getTeachwayId());
        user.setSubjectId(userDTO.getSubjectId());
        user.setCode(userDTO.getCode());
        user.setCost(userDTO.getCost());

        userService.addUser(user);
        return new ResponseEntity<>("User succesfully registered !", HttpStatus.CREATED);
    }
}
