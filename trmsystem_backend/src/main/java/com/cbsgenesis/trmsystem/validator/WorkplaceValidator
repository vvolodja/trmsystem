package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.Workplace;
import com.cbsgenesis.trmsystem.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of {@link WorkplaceValidator}
 *
 * @author Iryna Seliutina.
 */


@Component
@Configuration
@PropertySource("classpath:validation/validationSettings.properties")
public abstract class WorkplaceValidator implements Validator {

    @Autowired
    private WorkplaceService workplaceService;

    @Autowired
    private Environment environment;

    protected void validateField(String field, Errors errors){
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "key.required");
    }

    protected void validateWorkplaceCoincidence(Workplace entity, Errors errors){
        if(workplaceService.findByName(entity.getName())!= null) {
            errors.rejectValue("workplaceName", "key.duplicate.workplace.name");
        }
    }

    protected void validateWorkplaceName(Workplace entity, Errors errors){
        validateField("workplaceName", errors);
        if(!checkWorkplaceNameWithRegExp(entity.getName(),
        Integer.parseInt(environment.getProperty("key.min.count.characters.workplaceName")),
        Integer.parseInt(environment.getProperty("key.max.count.characters.workplaceName")))){
            entity.setName("");
            errors.rejectValue("workplaceName", "key.size.workplaceForm.workplaceName",
                    new String[]{String.valueOf(environment.getProperty("key.min.count.characters.workplaceName")),
            String.valueOf(environment.getProperty("key.max.count.characters.workplaceName"))}, null);
        }

    }

    private boolean checkWorkplaceNameWithRegExp(String str, int... key) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{" + key[0] + "," + key[1] + "}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
