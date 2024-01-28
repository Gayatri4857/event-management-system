package dto;


public class EventVenueResponse {

	private String message;
	private String eventType;
	private String capacity;
	private String cost;
	private String location;
	private String contacts;
	private String date;
	private String itemName;
	private String itemCost;
	private String equipmentName;
	private String equipmentCost;
	private int eventId;
	
	private EventVenueRequest eventData;
	
	
	
	public EventVenueRequest getEventData() {
		return eventData;
	}
	public void setEventData(EventVenueRequest eventData) {
		this.eventData = eventData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCost() {
		return itemCost;
	}
	public void setItemCost(String itemCost) {
		this.itemCost = itemCost;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentCost() {
		return equipmentCost;
	}
	public void setEquipmentCost(String equipmentCost) {
		this.equipmentCost = equipmentCost;
	}
}
