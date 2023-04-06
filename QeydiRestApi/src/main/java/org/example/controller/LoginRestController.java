package org.example.controller;

import org.example.dto.UserDTO;
import org.example.security.JwtTokenProvider;
import org.example.service.UserControlServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserControlServiceInter userControlService;

    @PostMapping("/sign-in")
    private String signIn(
            @RequestBody UserDTO userDTO
    ) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword());

        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwtToken = jwtTokenProvider.generateJwtToken(auth);

        return "Bearer " + jwtToken;
    }

    @PostMapping("/sign-up")
    private ResponseEntity<String> signUp(
            @RequestBody UserDTO userDTO
    ) {
        return userControlService.signUp(userDTO);
    }
}
