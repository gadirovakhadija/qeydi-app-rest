package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.dto.ResponseDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginRestController {
    @Autowired
    private UserServiceInter userService;

    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
    @GetMapping("/sign-in")
    public ResponseEntity<ResponseDTO> signIn(
//            @RequestParam(name="email", required= false) String email,
//            @RequestParam(name="password", required = false) String password
            @RequestBody UserDTO userDto
    ){
        User user = userService.findByEmail(userDto.getEmail());

        if (user == null) {
            throw new IllegalArgumentException("Istifadeci tapilmadi");
        }

        BCrypt.Result rs = verifyer.verify(userDto.getPassword().toCharArray(), user.getPassword().toCharArray());
        if (!rs.verified) {
            throw new IllegalArgumentException("Parol yanlishdir");
        }
        return ResponseEntity.ok(ResponseDTO.of(user));
    }

}
