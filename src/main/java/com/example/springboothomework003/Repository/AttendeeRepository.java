package com.example.springboothomework003.Repository;

import com.example.springboothomework003.Model.DTO.Request.AttendeeRequest;
import com.example.springboothomework003.Model.Entity.Attendee;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface AttendeeRepository {

	@Results(id = "attendeeMapper", value = {
			@Result(property = "attendeeId", column = "attendee_id"),
			@Result(property = "attendeeName", column = "attendee_name"),
	})
	@Select("""
			SELECT * FROM attendees
			OFFSET #{page}
			LIMIT #{size}
			""")
	List<Attendee> getAllAttendees(Integer page, Integer size);

	@ResultMap("attendeeMapper")
	@Select("""
			SELECT * FROM attendees
			WHERE attendee_id = #{attendeeId}
			""")
	Attendee getAttendeeById(Long attendeeId);

	@ResultMap("attendeeMapper")
	@Select("""
			INSERT INTO attendees
			VALUES (default, #{request.attendeeName}, #{request.email})
			RETURNING *
			""")
	Attendee createAttendee(@Param("request") AttendeeRequest request);

	@ResultMap("attendeeMapper")
	@Select("""
			UPDATE attendees
			SET attendee_name = #{request.attendeeName}
			, email = #{request.email}
			WHERE attendee_id = #{attendeeId}
			RETURNING *
			""")
	Attendee updateAttendee(Long attendeeId,@Param("request") AttendeeRequest request);

	@ResultMap("attendeeMapper")
	@Select("""
			DELETE FROM attendees
			WHERE attendee_id = #{attendeeId}
			RETURNING *
			""")
	void deleteAttendee(Long attendeeId);
}
