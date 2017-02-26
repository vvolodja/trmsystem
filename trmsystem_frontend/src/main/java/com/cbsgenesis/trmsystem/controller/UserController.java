package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.SecurityService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for {@link User}'s pages
 *
 * @author Eugene Suliemanov
 */

@Controller
@SessionAttributes(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome() {
        return "user/home";
    }
}