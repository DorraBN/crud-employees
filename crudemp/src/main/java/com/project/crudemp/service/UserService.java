package com.project.crudemp.service;

import com.project.crudemp.model.User;
import com.project.crudemp.web.dto.UserRegistrationDto; // Corrected the import

public interface UserService {
    User save(UserRegistrationDto registrationDto); // Corrected the parameter type
}
