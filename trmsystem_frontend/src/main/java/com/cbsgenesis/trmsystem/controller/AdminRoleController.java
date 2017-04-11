package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

/**
 * Created by Vasiliy Kylik on 31.03.2017.
 */
@Controller
public class AdminRoleController {
  @Autowired
  private RoleService roleService;

  @RequestMapping(value = "admin/roles", method = RequestMethod.GET)
  public String listRoles(Model model){
    model.addAttribute("role", new Role());
    model.addAttribute("listRoles", this.roleService.getAll());
    return "role/roles";
  }

  @RequestMapping(value = {"/", "admin/welcome"}, method = RequestMethod.GET)
  public String welcome(Model model) {
    return "admin/welcome";
  }

  @RequestMapping(value = "/role/add", method = RequestMethod.POST)
  public String addBook(@ModelAttribute("role") Role role, Model model) {
    this.roleService.save(role);
    model.addAttribute("role", this.roleService.getAll());
    return "redirect:admin/roles";
  }

  @RequestMapping("/remove/{id}")
  public String removeBook(@PathVariable("id") UUID id) {
    this.roleService.delete(this.roleService.getById(id));
    return "redirect:/admin/roles";
  }

  @RequestMapping("edit/{id}")
  public String editBook(@PathVariable("id") UUID id, Model model) {
    model.addAttribute("role", this.roleService.getById(id));
    model.addAttribute("roles", this.roleService.getAll());
    return "role/roles";
  }
}
