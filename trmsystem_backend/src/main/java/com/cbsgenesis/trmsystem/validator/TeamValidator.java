package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.TeamService;
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
 * Validation interface for class {@link Team}.
 *
 * @author Anton Lifyrenko
 */

@Component
@Configuration
@PropertySource("classpath:validation/validationSettings.properties")
public abstract class TeamValidator implements Validator {

    @Autowired
    private TeamService teamService;

    @Autowired
    private Environment env;

    /**
     * Method validates field if it's empty and notifies user
     */
    protected void validateField(String field, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "key.required");
    }

    /**
     * Method validates field if there are duplications in DB
     */
    protected void validateTeamNameCoincidence(Team team, Errors errors) {
        if (teamService.findByTeamName(team.getName()) != null) {
            errors.rejectValue("teamName", "key.duplicate.teamForm.name");
        }
    }


    /**
     * Method validates field if the amount of symbols is appropriate
     */
    protected void validateTeamName(Team team, Errors errors) {

        validateField("teamName", errors);
        if (!checkTeamNameWithRegExp(team.getName(),
                Integer.parseInt(env.getProperty("key.min.count.characters.teamName")),
                Integer.parseInt(env.getProperty("key.max.count.characters.teamName")))) {
            team.setName("");
            errors.rejectValue("teamName", "key.size.teamForm.teamName",
                    new String[]{String.valueOf(env.getProperty("key.min.count.characters.teamName")),
                            String.valueOf(env.getProperty("key.max.count.characters.teamName"))}, null);
        }
    }

    /**
     * Method validates field if there are some restricted symbols
     */
    private boolean checkTeamNameWithRegExp(String str, int... key) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{" + key[0] + "," + key[1] + "}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public TeamService getTeamService() {
        return teamService;
    }

    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }
}
