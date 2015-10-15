package com.springmvc4.model;

import com.springmvc4.validation.EventDuration;
import com.springmvc4.validation.ObjectName;
import com.springmvc4.validation.ValidUrl;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {

    private Long id;

    @ObjectName
    private String name;

    @NotNull
    private Date date;

    @NotNull
    private String location;

    @Min(1)
    @EventDuration
    private Integer duration; //duration in minutes

    @ValidUrl.List({
            @ValidUrl(protocol = "http"),
    })
    private String url;


    private List<Attendee> attendees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public int getAttendeessize() {
    	return attendees!=null?attendees.size():0;
    }
    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void print() {
    	System.out.println("Event : "+url);
    }
}
