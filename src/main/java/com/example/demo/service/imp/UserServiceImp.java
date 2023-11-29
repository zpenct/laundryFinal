package com.example.demo.service.imp;

import com.example.demo.OwnValidation.Validation;
import com.example.demo.dto.login.LoginRequestDTO;
import com.example.demo.dto.regsitration.RegistrationRequestDTO;
import com.example.demo.exception.AuthenticationException;
import com.example.demo.exception.EmailAlreadyUsedException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepos;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserServiceImp implements UserService {
    private final UserRepos userRepos;
//    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @Override
    @Transactional
    public User registerUser(RegistrationRequestDTO dto) {
        if (dto == null ||
                Validation.isNullOrEmpty(dto.getEmail()) ||
                Validation.isNullOrEmpty(dto.getPassword()) ||
                Validation.isNullOrEmpty(dto.getUsername())
        ) {
            throw new IllegalArgumentException("Isi Semua Field");
        }
        String email = dto.getEmail();
        if (userRepos.existsByEmail(email)) {
            throw new EmailAlreadyUsedException(email);
        }

        User newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setUsername(dto.getUsername());

//      newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setPassword(dto.getPassword());

        return userRepos.save(newUser);
    }

    @Override
    public User loginUser(LoginRequestDTO dto){
        String email = dto.getEmail();
        String password = dto.getPassword();

        User user = userRepos.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("User not registered: " + email));

        // Memeriksa kata sandi
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new UserAuthenticationException("Incorrect password for user: " + email);
//        }
        return user;
    }

}

