package com.example.springboothomework003.Repository;

import com.example.springboothomework003.Model.DTO.Request.VenueRequest;
import com.example.springboothomework003.Model.Entity.Venue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {


	@Results(id = "venueMapper", value = {
			@Result(property = "venueId", column = "venue_id"),
			@Result(property = "venueName", column = "venue_name")
	})

	@Select("""
			SELECT * FROM venues
			OFFSET #{page}
			LIMIT #{size}
			""")
	List<Venue> getAllVenues(Integer page, Integer size);

	@ResultMap("venueMapper")
	@Select("""
			SELECT * FROM venues
			WHERE venue_id = #{venueId}
			""")
	Venue getVenueById(Long venueId);

	@ResultMap("venueMapper")
	@Select("""
			INSERT INTO venues
			VALUES (default,#{request.venueName},#{request.location})
			RETURNING *
			""")
	Venue createVenue(@Param("request") VenueRequest request);

	@ResultMap("venueMapper")
	@Select("""
			UPDATE venues
			SET venue_name = #{request.venueName}
			, location = #{request.location}
			WHERE venue_id = #{venueId}
			RETURNING *
			""")
	Venue updateVenue(Long venueId, @Param("request") VenueRequest request);

	@ResultMap("venueMapper")
	@Select("""
			DELETE FROM venues
			WHERE venue_id = #{venueId}
			RETURNING *
			""")
	Venue deleteVenue(Long venueId);
}
