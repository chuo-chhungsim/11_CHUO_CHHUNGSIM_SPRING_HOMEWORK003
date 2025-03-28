package com.example.springboothomework003.Model.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
	private String eventName;
	private Date eventDate;
	private Long venueId;
	private List<Long> attendeesId;
}
