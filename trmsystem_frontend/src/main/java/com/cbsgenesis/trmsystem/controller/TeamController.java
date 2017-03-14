package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.SecurityService;
import com.cbsgenesis.trmsystem.service.TeamService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * Created by ANTON on 09.03.2017.
 */

@Controller
@SessionAttributes(value = "team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/teams", method = RequestMethod.GET)
    public String listTeams(Model model) {
        model.addAttribute("team", new Team());
        model.addAttribute("teams", teamService.getAll());
        model.addAttribute("supervisors", userService.getAllSupervisors());

        return "/team/teams";
    }

    @RequestMapping(value = "/admin/team/add", method = RequestMethod.POST)
    public String addTeam(@ModelAttribute("team") Team team, Model model) {
         if (team != null){
            teamService.save(team);
        }
        model.addAttribute("teams", teamService.getAll());
        return "/team/teams";
    }
}
