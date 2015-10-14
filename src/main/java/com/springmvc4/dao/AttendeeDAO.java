package com.springmvc4.dao;

import com.springmvc4.model.*;

import java.util.List;

public interface AttendeeDAO {
	
	public void createAttendee(Attendee attendee);
     
	public void saveAttendee(Attendee attendee);

	public Attendee get(int attendeeId);
     
    public List<Attendee> list();
    
    public void addToEvent(Attendee attendee, Event event);
    
    public Attendee createNew();

}
