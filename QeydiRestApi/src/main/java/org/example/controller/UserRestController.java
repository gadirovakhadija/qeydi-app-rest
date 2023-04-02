package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.security.JwtTokenProvider;
import org.example.service.inter.UserServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
//    @Autowired
    private AuthenticationManager authenticationManager;
//    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
    private UserServiceInter userService;

    public UserRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, UserServiceInter userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestBody UserDTO userDTO
    ) {
        List<User> users = userService.findAll();

        List<UserDTO> userDTOS = new ArrayList<>();

        for(int i=0;i<users.size();i++){
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }
        System.out.println(ResponseEntity.ok(ResponseDTO.of(userDTOS)));
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


}
