package com.example.demo.service;

import com.example.demo.dto.login.LoginRequestDTO;
import com.example.demo.dto.regsitration.RegistrationRequestDTO;
import com.example.demo.model.User;

public interface UserService {
    User registerUser(RegistrationRequestDTO dto);
    User loginUser(LoginRequestDTO dto);
}

