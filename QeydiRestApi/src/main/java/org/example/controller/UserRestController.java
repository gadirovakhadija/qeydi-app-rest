package org.example.controller;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(
            @PathVariable("id") int id
    ){
        User u = userService.findById(id);
        return ResponseEntity.ok(ResponseDTO.of(u));

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(
            @PathVariable("id") int id
    ) {
        User user = userService.findById(id);
        userService.deleteUserById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user),"Deleted Successfully"));
    }

    @PutMapping("/users")
    public ResponseEntity<ResponseDTO> updateUser(
            @RequestBody UserDTO userDto
    ){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAge(userDto.getAge());
        user.setExperience(userDto.getExperience());
        user.setUniversity(userDto.getUniversity());
        user.setPoint(userDto.getPoint());
        user.setCost(userDto.getCost());
        user.setCode(userDto.getCode());
        user.setSubjectId(userDto.getSubjectId());
        user.setTeachwayId(userDto.getTeachwayId());
        userService.updateUser(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        return ResponseEntity.ok(ResponseDTO.of(userDTO,"Successfully updated"));
    }

}
