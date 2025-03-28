package com.example.springboothomework003.Controller;

import com.example.springboothomework003.Model.DTO.Request.EventRequest;
import com.example.springboothomework003.Model.DTO.Response.ApiResponse;
import com.example.springboothomework003.Model.DTO.Response.DeleteResponse;
import com.example.springboothomework003.Model.Entity.Event;
import com.example.springboothomework003.Service.EventService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventController {
	private final EventService eventService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<Event>>> getAllEvent(@RequestParam(defaultValue = "1")@Min(1) Integer page,@RequestParam(defaultValue = "10")@Min(1) Integer size){
		List<Event> event = eventService.getAllEvent(page, size);
		ApiResponse<List<Event>> response = ApiResponse.
				<List<Event>>builder()
				.message("Events fetched all successfully")
				.payload(event)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{event-id}")
	public ResponseEntity<ApiResponse<Event>> getEventById(@PathVariable("event-id")@Min(1) Long eventId){
		Event event = eventService.getEventById(eventId);
		ApiResponse<Event> response = ApiResponse.
				<Event>builder()
				.message("Event fetched successfully")
				.payload(event)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Event>> createEvent(@Valid @RequestBody EventRequest request){
		Event event = eventService.createEvent(request);
		ApiResponse<Event> response = ApiResponse.
				<Event>builder()
				.message("Event created successfully")
				.payload(event)
				.status(HttpStatus.CREATED)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
	@PutMapping("/{event-id}")
	public ResponseEntity<ApiResponse<Event>> updateEvent(@PathVariable("event-id")@Min(1) Long eventId,
	                                                      @Valid @RequestBody EventRequest request){
		Event event = eventService.updateEvent(eventId, request);
		ApiResponse<Event> response = ApiResponse.
				<Event>builder()
				.message("Event updated successfully")
				.payload(event)
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{event-id}")
	public ResponseEntity<DeleteResponse<Event>> deleteEvent(@PathVariable("event-id")@Min(1) Long eventId){
		Event event = eventService.deleteEvent(eventId);
		DeleteResponse<Event> response = DeleteResponse.
				<Event>builder()
				.message("Event deleted successfully")
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
}
