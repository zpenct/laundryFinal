package com.example.demo;

import com.example.demo.controller.LaundryController;
import com.example.demo.controller.UserController;
import com.example.demo.dto.FasilitasRequestDTO;
import com.example.demo.dto.LaundryRequestDTO;
import com.example.demo.dto.LaundryResponseDTO;
import com.example.demo.dto.login.LoginRequestDTO;
import com.example.demo.dto.regsitration.RegistrationRequestDTO;
import com.example.demo.model.User;
import com.example.demo.repository.FasilitasRepos;
import com.example.demo.repository.LaundryRepos;
import com.example.demo.service.LaundryService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
//@WebMvcTest(UserController.class)
class UserTesting {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void SIGNUP_itShoulReturnSuccessMessageAndAdminData() throws Exception {
        RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
        registrationRequestDTO.setEmail("example@tes.com");
        registrationRequestDTO.setUsername("tes");
        registrationRequestDTO.setPassword("password123");


        // Mock data for registered user
        User registeredUser = new User();
        registeredUser.setId(1);
        registeredUser.setUsername("tes");
        registeredUser.setEmail("example@tes.com");
        registeredUser.setRole("ADMIN");

        // Mocking the userService to return the registered user
        Mockito.when(userService.registerUser(Mockito.any(RegistrationRequestDTO.class))).thenReturn(registeredUser);

        // Perform the registration request
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"example@tes.com\",\"password\":\"password123\"}"))
				.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("registrasi berhasil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("example@tes.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.role").value("ADMIN"));
    }

    @Test
    public void SIGNIN_itShoulReturnSuccessMessageAndAdminData() throws Exception {
        // Mock data for login request
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail("admin@admin.com");
        loginRequestDTO.setPassword("123");

        // Mock data for logged-in user
        User loggedInUser = new User();
        loggedInUser.setId(1);
        loggedInUser.setEmail("admin@admin.com");
        loggedInUser.setRole("ADMIN");

        // Mocking the userService to return the logged-in user
        Mockito.when(userService.loginUser(Mockito.any(LoginRequestDTO.class))).thenReturn(loggedInUser);

        // Perform the login request
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"admin@admin.com\",\"password\":\"123\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("login berhasil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("admin@admin.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.role").value("ADMIN"));
    }

    @Test
    void SIGNUP_itShoulReturnSuccessMessageAndUserData() throws Exception {
        RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
        registrationRequestDTO.setEmail("fatih@gmail.com");
        registrationRequestDTO.setUsername("Fatih");
        registrationRequestDTO.setPassword("123");


        // Mock data for registered user
        User registeredUser = new User();
        registeredUser.setId(2);
        registeredUser.setUsername("Fatih");
        registeredUser.setEmail("fatih@gmail.com");
        registeredUser.setRole("USER");

        // Mocking the userService to return the registered user
        Mockito.when(userService.registerUser(Mockito.any(RegistrationRequestDTO.class))).thenReturn(registeredUser);

        // Perform the registration request
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"fatih@gmail.com\",\"password\":\"123\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("registrasi berhasil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("fatih@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.role").value("USER"));
    }


    @Test
    public void SIGNIN_itShoulReturnSuccessMessageAndUserData() throws Exception {
        // Mock data for login request
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail("fatih@gmail.com");
        loginRequestDTO.setPassword("123");

        // Mock data for logged-in user
        User loggedInUser = new User();
        loggedInUser.setId(2);
        loggedInUser.setEmail("fatih@gmail.com");
        loggedInUser.setRole("USER");

        // Mocking the userService to return the logged-in user
        Mockito.when(userService.loginUser(Mockito.any(LoginRequestDTO.class))).thenReturn(loggedInUser);

        // Perform the login request
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"fatih@gmail.com\",\"password\":\"123\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("login berhasil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("fatih@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.role").value("USER"));
    }

}