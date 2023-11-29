package com.example.demo.controller;

import com.example.demo.dto.login.LoginRequestDTO;
import com.example.demo.dto.regsitration.RegistrationRequestDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/v1/auth")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequestDTO dto) {
        User registeredUser = service.registerUser(dto);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "registrasi berhasil");
        response.put("data", getUserResponse(registeredUser));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO dto) {
        User loginUser = service.loginUser(dto);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "login berhasil");
        response.put("data", getUserResponse(loginUser));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> tes() {
        return new ResponseEntity<>("kwokwowkewokeo", HttpStatus.OK);
    }

    private Map<String, Object> getUserResponse(User user) {
        Map<String, Object> userResponse = new HashMap<>();
        userResponse.put("id", user.getId());
        userResponse.put("email", user.getEmail());
        userResponse.put("username", user.getUsername());
        userResponse.put("role", user.getRole());
        return userResponse;
    }

}
