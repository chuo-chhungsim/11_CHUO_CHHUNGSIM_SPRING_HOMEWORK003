package com.example.springboothomework003.Controller;

import com.example.springboothomework003.Model.DTO.Request.AttendeeRequest;
import com.example.springboothomework003.Model.DTO.Response.ApiResponse;
import com.example.springboothomework003.Model.DTO.Response.DeleteResponse;
import com.example.springboothomework003.Model.Entity.Attendee;
import com.example.springboothomework003.Service.AttendeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {
	private final AttendeeService attendeeService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees(
			@RequestParam(defaultValue = "1") @Min(1) Integer page,
			@RequestParam(defaultValue = "10") @Min(1) Integer size) {
		List<Attendee> attendees = attendeeService.getAllAttendees(page, size);
		ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder()
				.message("Attendees fetched successfully")
				.payload(attendees)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{attendee-id}")
	public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable("attendee-id") @Min(1) Long attendeeId) {
		Attendee attendee = attendeeService.getAttendeeById(attendeeId);
		ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
				.message("Attendee id " + attendeeId + " fetched successfully")
				.payload(attendee)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Attendee>> createAttendee(@RequestBody @Valid AttendeeRequest request) {
		Attendee newAttendee = attendeeService.createAttendee(request);
		ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
				.message("Attendee added successfully")
				.payload(newAttendee)
				.status(HttpStatus.CREATED)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{attendee-id}")
	public ResponseEntity<ApiResponse<Attendee>> updateAttendee(
			@PathVariable("attendee-id") @Min(1) Long attendeeId,
			@RequestBody @Valid AttendeeRequest request) {
		Attendee updatedAttendee = attendeeService.updateAttendee(attendeeId, request);
		ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
				.message("Attendee id " + attendeeId + " updated successfully")
				.payload(updatedAttendee)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{attendee-id}")
	public ResponseEntity<DeleteResponse<Attendee>> deleteAttendee(@PathVariable("attendee-id") @Min(1) Long attendeeId) {
		attendeeService.deleteAttendee(attendeeId);
		DeleteResponse<Attendee> response = DeleteResponse.<Attendee>builder()
				.message("Attendee id " + attendeeId + " deleted successfully")
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
}
