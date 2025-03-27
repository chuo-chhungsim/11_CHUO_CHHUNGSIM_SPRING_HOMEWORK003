package com.example.springboothomework003.Service.IMPL;

import com.example.springboothomework003.Exception.NotFoundException;
import com.example.springboothomework003.Model.DTO.Request.VenueRequest;
import com.example.springboothomework003.Model.Entity.Venue;
import com.example.springboothomework003.Repository.VenueRepository;
import com.example.springboothomework003.Service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VenueImpl implements VenueService {
	private final VenueRepository venueRepository;

	@Override
	public List<Venue> getAllVenues(Integer page, Integer size) {
		page = (page - 1) * size;
		return venueRepository.getAllVenues(page,size);
	}

	@Override
	public Venue getVenueById(Long venueId) {
		Venue venue =  venueRepository.getVenueById(venueId);
		if(venue == null) {
			throw new NotFoundException(venueId);
		}
		return venue;
	}

	@Override
	public Venue createVenue(VenueRequest request) {
		return venueRepository.createVenue(request);
	}

	@Override
	public Venue updateVenue(Long venueId, VenueRequest request) {
		return venueRepository.updateVenue(venueId,request);
	}

	@Override
	public Venue deleteVenue(Long venueId) {
		Venue venue = venueRepository.deleteVenue(venueId);
		if(venue == null) {
			throw new NotFoundException(venueId);
		}
		return venue;
	}
}
