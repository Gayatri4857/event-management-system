package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.EventVenueRequest;
import org.dnyanyog.dto.EventVenueResponse;
import org.dnyanyog.entity.EventVenue;
import org.dnyanyog.services.EventManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventManagementController {

	@Autowired
	EventManagementService service;

	@PostMapping("/auth/venue")
	public EventVenueResponse addEventVenue(@RequestBody EventVenueRequest request) {
		return service.addVenue(request);
	}

	@GetMapping("/auth/venue/{event_search}")
	public EventVenueResponse searchEventvenue(@PathVariable String event_search) {
		return service.searchVenue(event_search);
	}

	@GetMapping("/auth/venue")
	public List<EventVenue> searchAllEventvenue() {
		return service.getVenues();
	}

	@PostMapping("/auth/venue/{event_search}")
	public EventVenueResponse updateEventVenue(@PathVariable String event_search, @RequestBody EventVenueRequest request) {
		return service.editVenue(event_search, request);
	}
	
	@DeleteMapping("/auth/venue/{event_search}")
	public EventVenueResponse deleteEvent(@PathVariable String event_search) {
		return service.deleteEvent(event_search);
	}
}
