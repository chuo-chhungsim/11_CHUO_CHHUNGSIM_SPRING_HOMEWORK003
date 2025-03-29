package com.example.springboothomework003.Model.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	private String eventName;
	private Date eventDate;
	private Long venueId;
	private List<Long> attendeesId;
}
