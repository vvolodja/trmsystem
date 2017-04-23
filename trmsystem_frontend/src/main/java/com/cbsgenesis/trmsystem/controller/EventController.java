package com.cbsgenesis.trmsystem.controller;

import com.cbsgenesis.trmsystem.model.Event;
import com.cbsgenesis.trmsystem.service.EventService;
import com.cbsgenesis.trmsystem.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for pages connected with event.
 *
 * @author Kyryl Potapenko
 * @since 2017-04-16
 */
@Controller
@SessionAttributes(value = "event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private WorkplaceService workplaceService;

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String saveEvent(@ModelAttribute("event") Event event, Model model) {
        if (event != null) {
            eventService.save(event);
        }
        model.addAttribute("event", new Event());
        model.addAttribute("event", eventService.getAll());
        model.addAttribute("workplace", workplaceService.getAll());
        return "calendar/event";
    }
}
