package com.cbsgenesis.trmsystem.validator;

import com.cbsgenesis.trmsystem.model.Event;
import com.cbsgenesis.trmsystem.service.EventService;
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
 * Created by Orange on 05.03.2017.
 */

@Component
@Configuration
@PropertySource("claspath:validationSettings.properties")
public abstract class EventValidator implements Validator {

    @Autowired
    private EventService eventService;

    @Autowired
    private Environment environment;

    protected void validateField(String field, Errors errors){
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "key.required");
    }

  protected void validateEventCoincidence (Event event, Errors errors){
        if (eventService.findByEventName(event.getName()) != null){
            errors.rejectValue("eventname", "key.duplicate.eventForm.eventname");
        }
  }

  protected void validateEventname(Event event, Errors errors){
      validateField("eventName", errors);

      if(!checkEventNameWithRegExp(event.getName(),
          Integer.parseInt(environment.getProperty("key.min.count.characters.eventName")),
          Integer.parseInt(environment.getProperty("key.max.count.characters.eventName")))){
          event.setName("");
          errors.rejectValue("eventName", "key.size.eventForm.eventName",
          new String[]{String.valueOf(environment.getProperty("key.min.count.characters.eventName")),
          String.valueOf(environment.getProperty("key.max.count.characters.eventName"))}, null);
      }
  }

private boolean checkEventNameWithRegExp(String string, int... key){
    Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{" + key[0] + "," + key[1] + "}$");
    Matcher m = p.matcher(string);
    return m.matches();
}

}