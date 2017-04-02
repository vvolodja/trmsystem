package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.service.RoleService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    return "admin/roles";
  }

  @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
  public String welcome(Model model) {
    return "user/home";
  }

  // TODO add mapping "/admin/roles/add" for role.jsp;
}
