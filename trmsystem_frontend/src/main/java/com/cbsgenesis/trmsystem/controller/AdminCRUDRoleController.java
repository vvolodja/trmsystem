package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.service.RoleService;
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
 * Created by Vasiliy Kylik on 31.03.2017.
 */
@Controller
public class AdminCRUDRoleController {

  @Autowired
  private RoleService roleService;

  @RequestMapping(value = "/admin/role/roles", method = RequestMethod.GET)
  public String listRoles(Model model) {
    model.addAttribute("role", new Role());
    model.addAttribute("listRoles", this.roleService.getAll());
    return "role/roles";
  }

/*  @RequestMapping(value = {"/", "role/welcome"}, method = RequestMethod.GET)
  public String welcome(Model model) {
    return "admin/welcome";
  }*/

  @RequestMapping(value = "/admin/role/add", method = RequestMethod.POST)
  public String addRole(@ModelAttribute("role") Role role, Model model) {

    if (role != null) {
      this.roleService.save(role);
    }
    model.addAttribute("listRoles", this.roleService.getAll());
    return "/role/roles";

  }

  @RequestMapping("admin/role/remove/{id}")
  public String removeRole(@PathVariable("id") UUID id) {

    this.roleService.delete(this.roleService.getById(id));
    return "redirect:/admin/role/roles";

  }

  @RequestMapping(value = "/admin/role/edit/{id}", method = RequestMethod.GET)
  public String editRole(@ModelAttribute("role") Role role, Model model) {

    model.addAttribute("role", this.roleService.getById(role.getId()));
    model.addAttribute("listRoles", this.roleService.getAll());
    return "/role/editRole";

  }

  @RequestMapping(value = "/admin/role/edit/{id}", method = RequestMethod.POST)
  public String editSubmit(@ModelAttribute("role") Role role, Model model) {

    if (role != null){
       this.roleService.save(role);
    }
    model.addAttribute("role", new Role());
    model.addAttribute("listRoles", this.roleService.getAll());
    return "/role/roles";

  }
}
