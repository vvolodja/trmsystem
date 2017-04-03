package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Alena on 18.03.2017.
 * * validator interface for {@link com.cbsgenesis.trmsystem.model.Status}
 */
@Component
@Configuration
@PropertySource("classpath:validation/validationSettings.properties")
public class StatusValidator implements Validator {

    @Autowired
    private StatusService statusService;

    @Autowired
    private Environment environment;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

    protected void validateField(String field, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "key.required");
    }
}

