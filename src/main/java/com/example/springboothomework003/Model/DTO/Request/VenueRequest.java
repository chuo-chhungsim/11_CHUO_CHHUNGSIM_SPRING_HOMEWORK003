package com.example.springboothomework003.Model.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
	@NotBlank(message = "Venue name cannot be blank")
	@NotNull
	@Size(min = 3, max = 100, message = "Venue name must be between 3 and 100 characters")
	private String venueName;
	@NotBlank(message = "Location cannot be blank")
	@NotNull
	private String location;
}
