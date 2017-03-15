package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for basic pages (About, Terms of Use, etc.)
 *
 * @author Eugene Suleimanov
 */

@Controller
public class BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        if (request.getUserPrincipal() != null) {
            User user = userService.findByUserName(request.getUserPrincipal().getName());
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "termsOfUse", method = RequestMethod.GET)
    public String termsOfUse() {
        return "basic/termsOfUse";
    }
}
