package com.example.springboothomework003.Controller;

import com.example.springboothomework003.Model.DTO.Request.VenueRequest;
import com.example.springboothomework003.Model.DTO.Response.ApiResponse;
import com.example.springboothomework003.Model.DTO.Response.DeleteResponse;
import com.example.springboothomework003.Model.Entity.Venue;
import com.example.springboothomework003.Service.VenueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
	private final VenueService venueService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(@RequestParam(defaultValue = "1") @Min(1) Integer page,
	                                                             @RequestParam(defaultValue = "10") @Min(1) Integer size) {
		List<Venue> venues = venueService.getAllVenues(page, size);
		ApiResponse<List<Venue>> response = ApiResponse.
				<List<Venue>>builder()
				.message("Venues fetched successfully")
				.payload(venues)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{venue-id}")
	public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable("venue-id") @Min(1) Long venueId) {
		Venue venue = venueService.getVenueById(venueId);
		ApiResponse<Venue> response = ApiResponse.
				<Venue>builder()
				.message("Venue id " + venueId + " fetched successfully")
				.payload(venue)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	private ResponseEntity<ApiResponse<Venue>> createVenue(@RequestBody @Valid VenueRequest request) {
		Venue newVenue = venueService.createVenue(request);
		ApiResponse<Venue> response = ApiResponse.
				<Venue>builder()
				.message("Venue added successfully")
				.payload(newVenue)
				.status(HttpStatus.CREATED)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{venue-id}")
	public ResponseEntity<ApiResponse<Venue>> updateVenue(@PathVariable("venue-id") @Min(1) Long venueId, @RequestBody @Valid VenueRequest request) {
		Venue updatedVenue = venueService.updateVenue(venueId, request);
		ApiResponse<Venue> response = ApiResponse.
				<Venue>builder()
				.message("Venue id " + venueId + " updated successfully")
				.payload(updatedVenue)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{venue-id}")
	public ResponseEntity<DeleteResponse<Venue>> deleteVenue(@PathVariable("venue-id")@Min(1) Long venueId) {
		venueService.deleteVenue(venueId);
		DeleteResponse<Venue> response = DeleteResponse
				.<Venue>builder()
				.message("Venue id " + venueId + " deleted successfully")
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
}
