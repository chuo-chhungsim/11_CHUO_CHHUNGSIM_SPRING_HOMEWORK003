package com.example.springboothomework003.Service.IMPL;

import com.example.springboothomework003.Exception.NotFoundException;
import com.example.springboothomework003.Model.DTO.Request.EventRequest;
import com.example.springboothomework003.Model.Entity.Event;
import com.example.springboothomework003.Repository.EventAttendeeRepository;
import com.example.springboothomework003.Repository.EventRepository;
import com.example.springboothomework003.Service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventImpl implements EventService {
	private final EventRepository eventRepository;
	private final EventAttendeeRepository eventAttendeeRepository;

	@Override
	public List<Event> getAllEvent(Integer page, Integer size) {
		page = (page - 1) * size;
		return eventRepository.getAllEvent(page, size);
	}

	@Override
	public Event getEventById(Long eventId) {
		Event event = eventRepository.getEventById(eventId);
		if (event == null) {
			throw new NotFoundException(eventId);
		}
		return event;
	}

	@Override
	public Event createEvent(EventRequest request) {
		Event newEvent = eventRepository.createEvent(request);
		for (Long attendeeId : request.getAttendeesId()) {
			eventAttendeeRepository.insertEventIdAndAttendeeId(newEvent.getEventId(), attendeeId);
		}
		return eventRepository.getEventById(newEvent.getEventId());
	}

	@Override
	public Event updateEvent(Long eventId, EventRequest request) {
		Event event = eventRepository.updateEvent(eventId, request);
		if (event == null) {
			throw new NotFoundException(eventId);
		}

		eventAttendeeRepository.removeAllEventAndAttendee(eventId);
		for (Long attendeeId : request.getAttendeesId()) {
			eventAttendeeRepository.insertEventIdAndAttendeeId(eventId, attendeeId);
		}
		return eventRepository.getEventById(event.getEventId());
	}

	@Override
	public Event deleteEvent(Long eventId) {
		Event event =  eventRepository.deleteEvent(eventId);
		if (event == null) {
			throw new NotFoundException(eventId);
		}
		return event;
	}

}
