package com.example.springboothomework003.Service;

import com.example.springboothomework003.Model.DTO.Request.AttendeeRequest;
import com.example.springboothomework003.Model.Entity.Attendee;

import java.util.List;

public interface AttendeeService {
	List<Attendee> getAllAttendees(Integer page, Integer size);

	Attendee getAttendeeById(Long attendeeId);

	Attendee createAttendee(AttendeeRequest request);

	Attendee updateAttendee(Long attendeeId, AttendeeRequest request);

	void deleteAttendee(Long attendeeId);
}
