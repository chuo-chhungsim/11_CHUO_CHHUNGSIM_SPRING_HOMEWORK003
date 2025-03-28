package com.example.springboothomework003.Service.IMPL;

import com.example.springboothomework003.Exception.NotFoundException;
import com.example.springboothomework003.Model.DTO.Request.AttendeeRequest;
import com.example.springboothomework003.Model.Entity.Attendee;
import com.example.springboothomework003.Repository.AttendeeRepository;
import com.example.springboothomework003.Service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeImpl implements AttendeeService {
	private final AttendeeRepository attendeeRepository;

	@Override
	public List<Attendee> getAllAttendees(Integer page, Integer size) {
		page = (page - 1) * size;
		return attendeeRepository.getAllAttendees(page, size);
	}

	@Override
	public Attendee getAttendeeById(Long attendeeId) {
		Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);
		if (attendee == null) {
			throw new NotFoundException(attendeeId);
		}
		return attendee;
	}

	@Override
	public Attendee createAttendee(AttendeeRequest request) {
		return attendeeRepository.createAttendee(request);
	}

	@Override
	public Attendee updateAttendee(Long attendeeId, AttendeeRequest request) {
		Attendee attendee =  attendeeRepository.updateAttendee(attendeeId, request);
		if (attendee == null){
			throw new NotFoundException(attendeeId);
		}
		return attendee;
	}

	@Override
	public Attendee deleteAttendee(Long attendeeId) {
		Attendee attendee =  attendeeRepository.deleteAttendee(attendeeId);
		if (attendee == null){
			throw new NotFoundException(attendeeId);
		}
		return attendee;
	}
}
