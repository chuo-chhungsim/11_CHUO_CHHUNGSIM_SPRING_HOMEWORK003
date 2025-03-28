package com.example.springboothomework003.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
	private Long eventId;
	private String eventName;
	private Date eventDate;
	private Venue venue;
	private List<Attendee> attendees;
}
