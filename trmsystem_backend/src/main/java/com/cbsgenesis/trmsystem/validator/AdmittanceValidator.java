package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.Admittance;
import com.cbsgenesis.trmsystem.service.AdmittanceService;
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
 * Validation interface for class {@link com.cbsgenesis.trmsystem.model.Admittance}.
 * implements {@link Validator}
 *
 * @author Kyryl Potapenko
 * @since 2017-03-03
 */
@Component
@Configuration
@PropertySource("classpath:validation/validationSettings.properties")
public abstract class AdmittanceValidator implements Validator {
    @Autowired
    private AdmittanceService admittanceService;
    @Autowired
    private Environment env;

    protected void validateField(String field, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "key.required");
    }

    protected void validateAdmittanceCoincidence(Admittance admittance, Errors errors) {

        if (admittanceService.findByName(admittance.getName()) != null) {
            errors.rejectValue("name", "key.duplicate.admittanceForm.admittancename");
        }
    }


    protected void validateAdmittanceName(Admittance admittance, Errors errors) {

        validateField("name", errors);

        if (!checkWithRegExp(admittance.getName(),
                Integer.parseInt(env.getProperty("key.min.count.characters.admittancename")),
                Integer.parseInt(env.getProperty("key.max.count.characters.admittancename")))) {
            admittance.setName("");
            errors.rejectValue("name", "key.size.admittanceForm.admittancename",
                    new String[]{String.valueOf(env.getProperty("key.min.count.characters.admittancename")),
                            String.valueOf(env.getProperty("key.max.count.characters.admittancename"))}, null);
        }
    }

    protected void validateAdmittanceDescription(Admittance admittance, Errors errors) {

        validateField("description", errors);

        if (!checkWithRegExp(admittance.getName(),
                Integer.parseInt(env.getProperty("key.min.count.characters.admittancename")),
                Integer.parseInt(env.getProperty("key.max.count.characters.admittancename")))) {
            admittance.setName("");
            errors.rejectValue("name", "key.size.admittanceForm.admittancename",
                    new String[]{String.valueOf(env.getProperty("key.min.count.characters.admittancename")),
                            String.valueOf(env.getProperty("key.max.count.characters.admittancedesc"))}, null);
        }
    }

    private boolean checkWithRegExp(String str, int... key) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{" + key[0] + "," + key[1] + "}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public AdmittanceService getUserService() {
        return admittanceService;
    }

    public void setUserService(AdmittanceService admittanceService) {
        this.admittanceService = admittanceService;
    }

}
