package org.example.service;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ResponseEntity<ResponseDTO> getUsers(UserDTO userDTO) {
        List<User> users = userService.findAll();

        List<UserDTO> userDTOS = new ArrayList<>();

        for(int i=0;i<users.size();i++){
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }
        System.out.println(ResponseEntity.ok(ResponseDTO.of(userDTOS)));
        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }

    @Override
    public ResponseEntity<ResponseDTO> getUser(int id) {
        User u = userService.findById(id);
        return ResponseEntity.ok(ResponseDTO.of(u));
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteUser(int id) {
        User user = userService.findById(id);
        userService.deleteUserById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user),"Deleted Successfully"));
    }

    @Override
    public ResponseEntity<String> updateUser(UserDTO userDTO){
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

    @Override
    public ResponseEntity<String> signUp(UserDTO userDTO) {
        if (userService.findByEmail(userDTO.getEmail()) != null)
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);

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
            return new ResponseEntity<>("Information isn't correct", HttpStatus.BAD_REQUEST);

        User user = userService.findByEmail(userDTO.getEmail());

        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return new ResponseEntity<>("User successfully registered !", HttpStatus.CREATED);
    }
}