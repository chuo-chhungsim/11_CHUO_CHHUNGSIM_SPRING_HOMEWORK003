package com.example.springboothomework003.Service;

import com.example.springboothomework003.Model.DTO.Request.EventRequest;
import com.example.springboothomework003.Model.Entity.Event;

import java.util.List;

public interface EventService {
	List<Event> getAllEvent(Integer page, Integer size);

	Event getEventById(Long eventId);

	Event createEvent(EventRequest request);

	Event updateEvent(Long eventId, EventRequest request);

	Event deleteEvent(Long eventId);
}
