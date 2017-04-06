package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.SecurityService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for pages connected with authentication (registration, forgot password, etc.)
 *
 * @author Eugene Suleimanov
 */

@Controller
@SessionAttributes(value = "userForm")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @ModelAttribute("userForm")
    public User createUser() {
        return new User();
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String authorization(Model model) {
        model.addAttribute("userForm", new User());

        return "authentication/signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "authentication/signUp";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        if (SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .contains("ROLE_ADMIN" )){
            return "admin/welcome";
        }
        return "user/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "authentication/login";
    }
}
