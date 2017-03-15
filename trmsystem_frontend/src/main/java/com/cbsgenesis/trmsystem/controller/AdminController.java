package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.service.SecurityService;
import com.cbsgenesis.trmsystem.service.TeamService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by ANTON on 09.03.2017.
 */

@Controller
@SessionAttributes(value = "admin")
public class AdminController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String welcome() {
        return "/admin";
    }
}
