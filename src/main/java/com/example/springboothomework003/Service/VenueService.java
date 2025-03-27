package com.example.springboothomework003.Service;

import com.example.springboothomework003.Model.DTO.Request.VenueRequest;
import com.example.springboothomework003.Model.Entity.Venue;
import java.util.List;
public interface VenueService {

	List<Venue> getAllVenues(Integer page,Integer size);

	Venue getVenueById(Long venueId);


	Venue createVenue(VenueRequest request);

	Venue updateVenue(Long venueId, VenueRequest request);

	Venue deleteVenue(Long venueId);
}
