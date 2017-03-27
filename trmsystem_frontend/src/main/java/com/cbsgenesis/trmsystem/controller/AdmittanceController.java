package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Admittance;
import com.cbsgenesis.trmsystem.service.AdmittanceService;
import com.cbsgenesis.trmsystem.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for pages connected with admittance.
 *
 * @author Kyryl Potapenko
 * @since 2017-03-22
 */
@Controller
@SessionAttributes(value = "admittance")
public class AdmittanceController {

    @Autowired
    private AdmittanceService admittanceService;

    @Autowired
    private SpecialistService specialistService;


    @RequestMapping(value = "/admin/admittances", method = RequestMethod.GET)
    public String listAdmittance(Model model) {
        model.addAttribute("admittance", new Admittance());
        model.addAttribute("admittance", admittanceService.getAll());
//        model.addAttribute("specialist", specialistService.getAll());
        return "/admittance/admittances";
    }

    @RequestMapping(value = "/admin/admittance/add", method = RequestMethod.POST)
    public String addAdmittance(@ModelAttribute("admittance") Admittance admittance, Model model) {
        if (admittance != null) {
            admittanceService.save(admittance);
        }
//        model.addAttribute("specialist", specialistService.getAll());
        model.addAttribute("admittance", admittanceService.getAll());
        return "/admittance/admittances";
    }

    @RequestMapping(value = "/admin/admittance/remove/{id}", method = RequestMethod.GET)
    public String removeAdmittance(@ModelAttribute("admittance") Admittance admittance, Model model) {

        if (admittance != null) {
            admittanceService.delete(admittance);
        }
        model.addAttribute("admittance", new Admittance());
        model.addAttribute("admittances", admittanceService.getAll());
//        model.addAttribute("specialist", specialistService.getAll());
        return "/admittance/admittances";
    }

    @RequestMapping(value = "/admin/admittance/edit/{id}", method = RequestMethod.GET)
    public String editAdmittance(@ModelAttribute("admittance") Admittance admittance, Model model) {
        model.addAttribute("admittance", admittanceService.getById(admittance.getId()));
        model.addAttribute("admittances", admittanceService.getAll());
//        model.addAttribute("specialist", specialistService.getAll());
        return "/admittance/editAdmittance";
    }

    @RequestMapping(value = "/admin/admittance/edit/{id}", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute("admittance") Admittance admittance, Model model) {
        if (admittance != null) {
            admittanceService.save(admittance);
        }
        model.addAttribute("admittance", new Admittance());
        model.addAttribute("admittances", admittanceService.getAll());
//        model.addAttribute("specialist", specialistService.getAll());
        return "/admittance/admittances";
    }
}
