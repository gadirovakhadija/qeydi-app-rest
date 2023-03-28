package org.example.controller;

import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.security.JwtTokenProvider;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
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

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDTO.getEmail(),userDTO.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        return "Bearer " + jwtToken;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody UserDTO userDTO
    ){
        if(userService.findByEmail(userDTO.getEmail())!=null)
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userService.addUser(user);
        return new ResponseEntity<>("User succesfully registered ", HttpStatus.CREATED);
    }

    @GetMapping("/users")
//    @CrossOrigin
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
