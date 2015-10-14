package com.springmvc4.dao;

import com.springmvc4.model.*;

import java.util.List;

public interface EventDAO {
	
	public Event createNew();
		
	public void deleteEvent(long eventId);
	
	public void saveEvent(Event event);
	
	public long createEvent(Event event);
     
    public Event findOne(long eventId);
    
    public Event getOne(long eventId);
     
    public List<Event> getAll();
    
    public List<Attendee> getAttendees(long eventId);

}
