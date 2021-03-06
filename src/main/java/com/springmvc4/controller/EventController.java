package com.springmvc4.controller;

import com.springmvc4.dao.EventDAO;
import com.springmvc4.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@Controller
@SessionAttributes("event")
@RequestMapping
public class EventController {

	@Autowired
    private EventDAO eventDAO;
    
	@Autowired
	private HttpSession session;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String addEvent(Model model, @RequestParam(value = "add", required = false) Boolean addNew) {
        boolean add = Boolean.TRUE.equals(addNew);
        Event event = new Event();
        if (event == null || add) {
            event = eventDAO.createNew(); //send a default event
        }
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
            return "event";
        }
        event.setId(eventDAO.createEvent(event));
        model.addAttribute("event", event);
        return "redirect:index.html";    
        //"redirect" erases all request attributes and sends user out of application to desired location in this case index.html
        //"forward" keeps the request attributes to continue the request forward
    }
  
    @RequestMapping(value = "showEvents", method = RequestMethod.GET)
    public String showEvents(Model model) {
        List<Event> events = eventDAO.getAll();
        model.addAttribute("allEvents", events);
        return "showEvents";
    }

    @RequestMapping(value = "showEvents", method = RequestMethod.POST)
    public String eventDetails(Model model, @RequestParam(value="eventId", required=false)long id){
    	Event event = eventDAO.getOne(id);
        model.addAttribute("event", event);
        return "redirect:index.html";
    }

}
