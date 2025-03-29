package com.example.springboothomework003.Model.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

	@NotBlank(message = "Event name is mandatory")
	@Size(max = 100, message = "Event name should not exceed 100 characters")
	private String eventName;

	@NotNull(message = "Event date is mandatory")
	private Date eventDate;

	@NotNull(message = "Venue ID is mandatory")
	private Long venueId;

	@NotNull(message = "Attendees ID list is mandatory")
	@Size(min = 1, message = "There must be at least one attendee")
	private List<Long> attendeesId;
}
