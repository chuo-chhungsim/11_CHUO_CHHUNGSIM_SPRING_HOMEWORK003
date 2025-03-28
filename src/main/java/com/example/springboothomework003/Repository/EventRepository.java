package com.example.springboothomework003.Repository;

import com.example.springboothomework003.Model.DTO.Request.EventRequest;
import com.example.springboothomework003.Model.Entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

	@Results(id = "eventMapper", value = {
			@Result(property = "eventId", column = "event_id"),
			@Result(property = "eventName", column = "event_name"),
			@Result(property = "eventDate", column = "event_date"),
			@Result(property = "venue", column = "venue_id",
					one = @One(select = "com.example.springboothomework003.Repository.VenueRepository.getVenueById")),
			@Result(property = "attendees", column = "event_id",
					many = @Many(select = "com.example.springboothomework003.Repository.EventAttendeeRepository.getAttendeeByEventId"))
	})
	@Select("""
			SELECT * FROM events
			OFFSET #{page}
			LIMIT #{size}
			""")
	List<Event> getAllEvent(Integer page, Integer size);

	@ResultMap("eventMapper")
	@Select("""
			SELECT * FROM events
			WHERE event_id = #{eventId}
			""")
	Event getEventById(Long eventId);

	@ResultMap("eventMapper")
	@Select("""
			INSERT INTO events
			VALUES (default,#{request.eventName},#{request.eventDate},#{request.venueId})
			RETURNING *
			""")
	Event createEvent(@Param("request") EventRequest request);

	@ResultMap("eventMapper")
	@Select(("""
			UPDATE events
			SET event_name = #{request.eventName},
			 event_date = #{request.eventDate},
			 venue_id = #{request.venueId}
			WHERE event_id = #{eventId}
			RETURNING *
			"""))
	Event updateEvent(Long eventId, @Param("request") EventRequest request);

	@ResultMap("eventMapper")
	@Select("""
			DELETE FROM events
			WHERE event_id = #{eventId}
			RETURNING *
			""")
	Event deleteEvent(Long eventId);
}
