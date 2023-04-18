package org.example.service;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserControlServiceImpl implements UserControlServiceInter {
    private final UserServiceInter userService;
    private final PasswordEncoder passwordEncoder;

    public UserControlServiceImpl(UserServiceInter userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<ResponseDTO> getUsers() {

        List<User> users = userService.findAll();

        List<ResponseDTO> responseDTOs = new LinkedList<>();
        for (User user : users) {
            responseDTOs.add(ResponseDTO.of(user));
        }

        return responseDTOs;

    }

    @Override
    public ResponseDTO getUser(int id) {
        return ResponseDTO.of(userService.findById(id));
    }

    @Override
    public ResponseDTO deleteUser(int id) {
        User user = userService.findById(id);
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        userService.deleteUserById(id);

        return ResponseDTO.of(new UserDTO(user), "Deleted Successfully");
    }

    @Override
    public String updateUser(UserDTO userDTO) {
        if (userService.findUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()) == null)
            throw new UsernameNotFoundException("User not found");

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
        return "User succesfully registered !";
    }

    @Override
    public ResponseEntity<String> signUp(UserDTO userDTO) {
        if (userService.findByEmail(userDTO.getEmail()) != null)
            throw new IllegalArgumentException("User Already in use");
//            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userService.addUser(user);
        return new ResponseEntity<>("User succesfully registered ", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> reset(UserDTO userDTO) {
        if (userService.findUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()) == null)
            throw new IllegalArgumentException("Infomation doesn't correct");
//            return new ResponseEntity<>("Information isn't correct", HttpStatus.BAD_REQUEST);

        User user = userService.findByEmail(userDTO.getEmail());

        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return new ResponseEntity<>("User successfully registered !", HttpStatus.CREATED);
    }


    @Override
    public List<User> findUsersByTeachway(String teachway) {
        return userService.findByTeachway(teachway);
    }

    @Override
    public List<User> findUsersBySubject(String subject) {
        return userService.findBySubject(subject);
    }

}
