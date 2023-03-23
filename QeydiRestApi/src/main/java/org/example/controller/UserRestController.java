package org.example.controller;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "email", required = false) String email
    ) {
        List<User> users = userService.getAll(name, surname, email);

        List<UserDTO> userDTOS = new ArrayList<>();

        for(int i=0;i<users.size();i++){
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }

        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }


}
