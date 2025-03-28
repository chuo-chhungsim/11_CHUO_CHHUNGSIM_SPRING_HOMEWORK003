package com.example.springboothomework003.Repository;


import com.example.springboothomework003.Model.Entity.Attendee;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface EventAttendeeRepository {


	@Results(id = "eventAttendeeMapper", value = {
			@Result(property = "attendeeId", column = "attendee_id"),
			@Result(property = "attendeeName", column = "attendee_name"),
	})
	@Select("""
			SELECT * FROM event_attendee ea
			INNER JOIN attendees a
			ON ea.attendee_id = a.attendee_id
			WHERE event_id = #{eventId}
			""")
	List<Attendee> getAttendeeByEventId(Long eventId);

	@Insert("""
			INSERT INTO event_attendee
			VALUES (default,#{eventId},#{attendeeId})
			""")
	void insertEventIdAndAttendeeId(Long eventId, Long attendeeId);

	@Delete("""
			DELETE FROM event_attendee
			WHERE event_id = #{eventId}
			""")
	void deleteEventIdAndAttendeeId(Long eventId, Long attendeeId);

	@Delete(("""
			DELETE FROM event_attendee
			WHERE event_id = #{eventId}
			"""))
	void removeAllEventAndAttendee(Long eventId);

}
