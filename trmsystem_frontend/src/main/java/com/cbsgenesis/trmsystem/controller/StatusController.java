package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Status;
import com.cbsgenesis.trmsystem.service.StatusService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Alena on 23.03.2017.
 * Controller for pages {@link Status}
 */
@Controller
@SessionAttributes(value = "status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/status", method = RequestMethod.GET)
    public String statusCollection(Model model) {
        model.addAttribute("status", new Status());
        model.addAttribute("statuses", statusService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());
        return "/status/statuses";
    }

    @RequestMapping(value = "/admin/status/add", method = RequestMethod.POST)
    public String addStatus(@ModelAttribute("status") Status status, Model model) {
        if (status != null) {
            statusService.save(status);
        }
        model.addAttribute("supervisors", userService.getAllSupervisors());
        model.addAttribute("statuses", statusService.getAll());
        return "/status/statuses";
    }

    @RequestMapping(value = "/admin/status/remove/{id}", method = RequestMethod.GET)
    public String removeStatus(@ModelAttribute("status") Status status, Model model) {
        if (status != null) {
            statusService.delete(status);
        }

        model.addAttribute("status", new Status());
        model.addAttribute("statuses", statusService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());
        return "/status/statuses";
    }

    @RequestMapping(value = "/admin/status/edit/{id}", method = RequestMethod.POST)
    public String editStatus(@ModelAttribute("status") Status status, Model model) {
        model.addAttribute("status", statusService.getById(status.getId()));
        model.addAttribute("statuses", statusService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());
        return "/status/statuses";
    }

}
