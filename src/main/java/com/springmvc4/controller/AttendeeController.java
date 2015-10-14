package com.springmvc4.controller;

import com.springmvc4.dao.AttendeeDAO;
import com.springmvc4.dao.EventDAO;
import com.springmvc4.model.Attendee;
import com.springmvc4.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping
public class AttendeeController {

	@Autowired
	private AttendeeDAO attendeeDAO;

	@Autowired
	private EventDAO eventDAO;

	@RequestMapping(value = "/attendee", method = RequestMethod.GET)
	public String attendee(Model model) {
		Attendee attendee = attendeeDAO.createNew();
		model.addAttribute("attendee", attendee);
		return "attendee";
	}

	@RequestMapping(value = "/attendee", method = RequestMethod.POST)
	public String attendee(@Valid @ModelAttribute Attendee attendee) {
		Event event = eventDAO.findOne(attendee.getEventId());
		if (event == null) {
			return "redirect:index.html";
		}
		attendeeDAO.addToEvent(attendee, event);
		return "redirect:index.html";
	}
}
