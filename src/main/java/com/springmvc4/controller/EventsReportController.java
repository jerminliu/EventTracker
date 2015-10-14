package com.springmvc4.controller;

import com.springmvc4.dao.EventDAO;
import com.springmvc4.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class EventsReportController {

    @Autowired
    private EventDAO eventDAO;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Event> getEvents() {

        return eventDAO.getAll();

    }
}
