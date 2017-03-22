package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.Specialist;
import com.cbsgenesis.trmsystem.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validation interface for class {@link Specialist}.
 *
 * @author Dmitriy Saltykov
 */

@Component
@Configuration
@PropertySource("classpath:validation/validationSettings.properties")
public abstract class SpecialistValidator implements Validator {

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private Environment env;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
