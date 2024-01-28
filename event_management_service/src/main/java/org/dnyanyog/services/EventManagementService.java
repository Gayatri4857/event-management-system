package org.dnyanyog.services;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.EventData;
import org.dnyanyog.dto.EventVenueRequest;
import org.dnyanyog.dto.EventVenueResponse;
import org.dnyanyog.entity.EventVenue;
import org.dnyanyog.repo.EventVenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventManagementService {

	@Autowired
	EventVenueRepository repo;

	@Autowired
	EventVenueResponse response;
	

	public EventVenueResponse addVenue(EventVenueRequest request) {

		EventVenue eventVenue = new EventVenue();
		eventVenue.setEventType(request.getEventType());
		eventVenue.setCapacity(request.getCapacity());
		eventVenue.setLocation(request.getLocation());
		eventVenue.setCost(request.getCost());
		eventVenue.setContacts(request.getContacts());
		eventVenue.setDate(request.getDate());
		eventVenue.setItemName(request.getItemName());
		eventVenue.setItemCost(request.getItemCost());
		eventVenue.setEquipmentName(request.getEquipmentName());
		eventVenue.setEquipmentCost(request.getEquipmentCost());
		
		eventVenue = repo.save(eventVenue);

		response.setMessage("Venue added successfully !!");
		response.setEventType(request.getEventType());
		response.setCapacity(request.getCapacity());
		response.setLocation(request.getLocation());
		response.setContacts(request.getContacts());
		response.setCost(request.getCost());
		response.setDate(request.getDate());
		response.setItemName(request.getItemName());
		response.setItemCost(request.getItemCost());
		response.setEquipmentName(request.getEquipmentName());
		response.setEquipmentCost(request.getEquipmentCost());
		response.setEventId(eventVenue.getEventId());
		

		return response;

	}

	public EventVenueResponse editVenue(String event_search, EventVenueRequest request) {

		List<EventVenue> editVenue = repo.findByeventType(event_search);
		if (editVenue.isEmpty()) {
			response.setMessage("Venue not found !!");
		} else {
			EventVenue venue = editVenue.get(0);
			venue.setEventType(request.getEventType());
			venue.setCapacity(request.getCapacity());
			venue.setContacts(request.getContacts());
			venue.setLocation(request.getLocation());
			venue.setCost(request.getCost());
			venue.setDate(request.getDate());
			venue.setItemName(request.getItemName());
			venue.setItemCost(request.getItemCost());
			venue.setEquipmentName(request.getEquipmentName());
			venue.setEquipmentCost(request.getEquipmentCost());
			
			repo.save(venue);
			
			response.setMessage("Venue updated successfully !!");
		}

		return response;
	}

	public EventVenueResponse searchVenue(String event_search) {

		List<EventVenue> venueTable = repo.findByeventType(event_search);

		if (venueTable.isEmpty()) {
			response.setMessage("Venue not found");
		} else {
			EventVenue eventVenue = venueTable.get(0);
			response.setMessage("Venue searched successfully !!");
			
			EventData eventData = response.getEventData();
			
			eventData.setEventType(eventVenue.getEventType());
			eventData.setLocation(eventVenue.getLocation());
			eventData.setCapacity(eventVenue.getCapacity());
			eventData.setContacts(eventVenue.getContacts());
			eventData.setCost(eventVenue.getCost());
			eventData.setDate(eventVenue.getDate());
			eventData.setItemName(eventVenue.getItemName());
			eventData.setItemCost(eventVenue.getItemCost());
			eventData.setEquipmentName(eventVenue.getEquipmentName());
			eventData.setEquipmentCost(eventVenue.getEquipmentCost());
			

		}
		return response;

	}

	public List<EventVenue> getVenues() {
		return repo.findAll();
	}

	/*public String cancleVenue(String event_search) {
		repo.findByeventType(event_search);
		return "Venue cancled !!";
	}
*/
	public EventVenueResponse deleteEvent(String event_search) {
		
		List<EventVenue> existingEvent = repo.findByeventType(event_search);
		
		if(existingEvent.isEmpty()) {
			response.setMessage("Event not found");
		}
		else {
			
			EventVenue eventVenue = existingEvent.get(0);
			repo.delete(eventVenue);
			
			response.setMessage("Event deleted Successfully");
			response.setEventType(eventVenue.getEventType());
			response.setLocation(eventVenue.getLocation());
			response.setCapacity(eventVenue.getCapacity());
			response.setContacts(eventVenue.getContacts());
			response.setCost(eventVenue.getCost());
			response.setDate(eventVenue.getDate());
			response.setItemName(eventVenue.getItemName());
			response.setItemCost(eventVenue.getItemCost());
			response.setEquipmentName(eventVenue.getEquipmentName());
			response.setEquipmentCost(eventVenue.getEquipmentCost());
		}
		return response;
	}
	
	
	
	
}
