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
public class RoleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Role role = (Role) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userType", "required.role");
    }
}

