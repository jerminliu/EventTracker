package com.springmvc4.model;


import com.springmvc4.validation.ObjectName;
import com.springmvc4.validation.Phone;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Attendee {

	//@NotNull
	private Long attendeeId;	 
	 
    public Long getAttendeeId() {
		return attendeeId;
	}

	public void setId(Long id) {
		attendeeId = id;
	}
	
	@NotNull
	private Long eventId;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	
    @NotEmpty(message = "Email is mandatory.")
    @Size(min = 2)
    @Email
    private String email;

    @NotNull
    @ObjectName
    private String name;

    private String gender;

    @Phone
    private String phone;

    @NotNull
    private String company;
    
    
    public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAttendeeId(Long attendeeId) {
		this.attendeeId = attendeeId;
	}

	public Attendee(){

    }

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
