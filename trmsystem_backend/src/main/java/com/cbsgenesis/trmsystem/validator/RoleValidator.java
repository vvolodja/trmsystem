package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.HashSet;

/**
 * Created by Vasiliy Kylik on 12.03.2017.
 */
@Component
public abstract class RoleValidator implements Validator {

    //which objects can be validated by this validator
    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.isAssignableFrom(clazz);
    }

    // Check if at least one role assign to a user
    public void validateUserType(User user, Errors errors) {
        if (user.getRoles().isEmpty()) {
            user.setRoles(new HashSet<Role>());
            errors.reject("userType", "Please Select Role");
            // if role(s) assigned to a user, check the validity of values
        }
        for (Role role : user.getRoles()) {
            if (!role.getName().equals("ROLE_USER") || !role.getName().equals("ROLE_ADMIN")) {
                user.setRoles(new HashSet<Role>());
                errors.reject("userType", "Please Select Correct Role");
            }
        }
    }
}

