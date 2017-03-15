package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.UserService;
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
 * Validation interface for class {@link User}.
 *
 * @author Eugene Suleimanov
 */

@Component
@Configuration
@PropertySource("classpath:validation/validationSettings.properties")
public abstract class UserValidator implements Validator {


    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;


    protected void validateField(String field, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "key.required");
    }

    protected void validateUsernameCoincidence(User user, Errors errors) {

        if (userService.findByUserName(user.getUsername()) != null) {
            errors.rejectValue("username", "key.duplicate.userForm.username");
        }
    }

    protected void validateUsername(User user, Errors errors) {

        validateField("username", errors);

        if (!checkUserNameWithRegExp(user.getUsername(),
                Integer.parseInt(env.getProperty("key.min.count.characters.username")),
                Integer.parseInt(env.getProperty("key.max.count.characters.username")))) {
            user.setUsername("");
            errors.rejectValue("username", "key.size.userForm.username",
                    new String[]{String.valueOf(env.getProperty("key.min.count.characters.username")),
                            String.valueOf(env.getProperty("key.max.count.characters.username"))}, null);
        }
    }


    protected void validatePassword(User user, Errors errors) {

        validateField("password", errors);

        if (!checkPasswordWithRegExp(user.getPassword(),
                Integer.parseInt(env.getProperty("key.min.count.characters.password")),
                Integer.parseInt(env.getProperty("key.max.count.characters.password")))) {
            user.setPassword("");
            errors.rejectValue
                    ("password", "key.size.userForm.password",
                            new String[]{String.valueOf(env.getProperty("key.min.count.characters.password")),
                                    String.valueOf(env.getProperty("key.max.count.characters.password"))}, null);
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            user.setConfirmPassword("");
            errors.rejectValue("confirmPassword", "key.different.userForm.password");
        }

    }

    protected void validateEmail(User user, Errors errors) {

        validateField("email", errors);

        if (!checkEmailWithRegExp(user.getEmail())) {
            user.setEmail("");
            errors.rejectValue
                    ("email", "key.not.correctly.email");
        }
    }


    private boolean checkUserNameWithRegExp(String str, int... key) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{" + key[0] + "," + key[1] + "}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private boolean checkPasswordWithRegExp(String str, int... key) {
        Pattern p = Pattern.compile(
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{"
                        + key[0] + "," + key[1] + "}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private boolean checkEmailWithRegExp(String str) {
        Pattern p = Pattern.compile("^[-\\w\\W.]+@[-\\w\\W][^@]+$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
