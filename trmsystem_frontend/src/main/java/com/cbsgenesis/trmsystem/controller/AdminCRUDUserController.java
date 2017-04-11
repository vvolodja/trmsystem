package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

/**
 * Created by Vasiliy Kylik on 12.04.2017.
 */
@Controller
public class AdminCRUDUserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/admin/user/users", method = RequestMethod.GET)
  public String listUsers(Model model) {

    model.addAttribute("user", new User());
    model.addAttribute("listUsers", this.userService.getAll());
    return "user/users";

  }

  @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
  public String addUser(@ModelAttribute("user") User user, Model model) {

    if (user != null) {
      this.userService.save(user);
    }
    model.addAttribute("listUsers", this.userService.getAll());
    return "/user/users";

  }

  @RequestMapping("admin/user/remove/{id}")
  public String removeUser(@PathVariable("id") UUID id) {

    this.userService.delete(this.userService.getById(id));
    return "redirect:/admin/user/users";

  }

  @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.GET)
  public String editUser(@ModelAttribute("user") User user, Model model) {

    model.addAttribute("user", this.userService.getById(user.getId()));
    model.addAttribute("listUsers", this.userService.getAll());
    return "/user/editUser";

  }

  @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.POST)
  public String editSubmit(@ModelAttribute("user") User user, Model model) {

    if (user != null){
      this.userService.save(user);
    }
    model.addAttribute("user", new User());
    model.addAttribute("listUsers", this.userService.getAll());
    return "/user/users";

  }
}