package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Workplace;
import com.cbsgenesis.trmsystem.service.UserService;
import com.cbsgenesis.trmsystem.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Implementation of {@link WorkplaceController}.
 *
 * Author: Iryna Seliuttna.
 */

@Controller
@SessionAttributes(value = "workplace")
public class WorkplaceController {

    @Autowired
    private WorkplaceService workplaceService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "admin/workplaces", method = RequestMethod.GET)
    public String listWorkplaces(Model model){
        model.addAttribute("workplace", new Workplace());
        model.addAttribute("workplaces", workplaceService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());

        return "/workplace/workplaces";
    }

    @RequestMapping(value = "admin/workplace/add", method = RequestMethod.POST)
    public String addWorkplace(@ModelAttribute("workplace") Workplace entity, Model model){
        if(entity !=null){
            workplaceService.save(entity);
        }
        model.addAttribute("Supervisors", userService.getAllSupervisors());
        model.addAttribute("workplaces", workplaceService.getAll());

        return "/workplace/workplaces";
    }

    @RequestMapping(value = "admin/workplace/edit/{id}", method = RequestMethod.GET)
    public String editWorkplace(@ModelAttribute("workplace") Workplace entity, Model model){
        model.addAttribute("workplace", workplaceService.getById(entity.getId()));
        model.addAttribute("workplaces", workplaceService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());

        return "/workplace/editWorkplace";
    }

    @RequestMapping(value = "admin/workplace/edit/{id}", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute("workplace") Workplace entity, Model model){
        if(entity != null) {
            workplaceService.save(entity);
        }
        model.addAttribute("workplace", workplaceService.getById(entity.getId()));
        model.addAttribute("workplaces", workplaceService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());

        return "/workplace/workplaces";
    }

    @RequestMapping(value = "admin/workplace/remove/{id}", method = RequestMethod.GET)
    public String removeWorkplace(@ModelAttribute("workplace") Workplace entity, Model model){
        if(entity != null) {
            workplaceService.delete(entity);
        }
        model.addAttribute("workplace", new Workplace());
        model.addAttribute("workplaces", workplaceService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());

        return "/workplace/workplaces";
    }
}