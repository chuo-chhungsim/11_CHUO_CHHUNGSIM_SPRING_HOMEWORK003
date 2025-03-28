package com.example.springboothomework003.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendee {
	private Long attendeeId;
	private String attendeeName;
	private String email;
}
