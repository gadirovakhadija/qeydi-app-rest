package org.example.controller;

import org.example.dto.ResponseDTO;
import org.example.entity.User;
import org.example.service.UserControlServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserControlServiceInter userControlService;

    @GetMapping
    private ResponseEntity<List<ResponseDTO>> getUsers(
    ) {
        List<ResponseDTO> u = userControlService.getUsers();
        return ResponseEntity.ok(u);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseDTO> getUser(
            @PathVariable("id") int id
    ) {
        return ResponseEntity.ok(userControlService.getUser(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseDTO> deleteUser(
            @PathVariable("id") int id
    ) {
        return ResponseEntity.ok(userControlService.deleteUser(id));
    }


    @GetMapping("/teachway/")
    public ResponseEntity<List<User>> getUsersByTeachway(@RequestParam String teachway) {

        List<User> userList = userControlService.findUsersByTeachway(teachway);
        return ResponseEntity.ok(userList);

    }


    @GetMapping("/subject/")
    public ResponseEntity<List<User>> getUsersBySubject(@RequestParam String subject) {

        List<User> userList = userControlService.findUsersBySubject(subject);
        return ResponseEntity.ok(userList);

    }


}
