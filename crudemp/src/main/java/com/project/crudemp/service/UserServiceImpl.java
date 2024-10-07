package com.project.crudemp.service;

import java.util.Collections; // Import Collections instead of Arrays

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.crudemp.model.Role;
import com.project.crudemp.model.User;
import com.project.crudemp.repository.UserRepository;
import com.project.crudemp.web.dto.UserRegistrationDto; // Corrected the import for UserRegistrationDto

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; // Declaration of the repository

    // Constructor for dependency injection
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) { // Corrected the parameter type
        User user = new User(
            registrationDto.getName(),
            registrationDto.getEmail(),
            registrationDto.getPassword(),
            Collections.singletonList(new Role("ROLE_USER")) // Use "ROLE_USER" for standard role naming
        );
        return userRepository.save(user);
    }
}
