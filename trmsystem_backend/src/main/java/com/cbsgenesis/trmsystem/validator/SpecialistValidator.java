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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * Method validates field if there are some restricted symbols
     * @param str
     * @param key
     * @return
     */
    private boolean checkSpecialistNameWithRegExp(String str, int... key) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z.]{" + key[0] + "," + key[1] + "}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * Method validates field if there are duplications in DB
     * @param specialist
     * @param errors
     */
    protected void validateTeamNameCoincidence(Specialist specialist, Errors errors) {
        if (specialistService.findByLastName(specialist.getLastName()) != null) {
            errors.rejectValue("teamName", "key.duplicate.teamForm.name");
        }
    }

    /**
     *
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    /**
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {

    }
}
