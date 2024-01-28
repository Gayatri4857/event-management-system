package search_update_screen;

import java.io.IOException;
import java.sql.SQLException;

import common.RestUtil;
import dto.EventVenueRequest;
import dto.EventVenueResponse;
import frount_page.FrountPage;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchUpdateScreenController {
	@FXML
	private TextField event_search;
	
	@FXML
	private TextField EventType;
	
	@FXML
	private TextField Capacity;
	
	@FXML
	private TextField Cost;
	
	@FXML
	private TextField Location;
	
	@FXML
	private TextField Contacts;
	
	@FXML
	private TextField Date;
	
	@FXML
	private TextField ItemName;
	
	@FXML
	private TextField ItemCost;
	
	@FXML
	private TextField EquipmentName;
	
	@FXML
	private TextField EquipmentCost;
	
	@FXML
	private Button Logout_Button;
	
	@FXML
	private Button Search_Button;
	
	@FXML
	private Button Back;
	
	@FXML
	private Button update_button;
	
	
	/*private void Search(ActionEvent event) throws IOException, InterruptedException{
		
		String SearchQuery ="http://localhost:8081/auth/venue/" + event_search.getText();
		EventVenueResponse eventResponse = RestUtil.sendGetRequest(SearchQuery,EventVenueResponse.class);
		
		if(eventResponse.getMessage().equals("Fail")) {
			System.out.println("User not found");
		}
		else {
			 EventVenueRequest eventRequest = eventResponse.getEventData();
			 EventType.setText(eventRequest.getEventType());
			 Capacity.setText(eventRequest.getCapacity());
			 Cost.setText(eventRequest.getCost());
			 Location.setText(eventRequest.getLocation());
			 Contacts.setText(eventRequest.getContacts());
			 Date.setText(eventRequest.getDate());
			 ItemName.setText(eventRequest.getItemName());
			 ItemCost.setText(eventRequest.getItemCost());
			 EquipmentName.setText(eventRequest.getEquipmentName());
			 EquipmentCost.setText(eventRequest.getEquipmentCost());
			 System.out.println("User found !!");
		}
	}
	*/
	public void Update(ActionEvent event) throws IOException, InterruptedException {
		
		EventVenueRequest eventRequest = new EventVenueRequest();
		eventRequest.setEventType(EventType.getText());
		eventRequest.setCapacity(Capacity.getText());
		eventRequest.setCost(Cost.getText());
		eventRequest.setLocation(Location.getText());
		eventRequest.setContacts(Contacts.getText());
		eventRequest.setDate(Date.getText());
		eventRequest.setItemName(ItemName.getText());
		eventRequest.setItemCost(ItemCost.getText());
		eventRequest.setEquipmentName(EquipmentName.getText());
		eventRequest.setEquipmentCost(EquipmentCost.getText());
		
		System.out.println(event_search.getText());
		String updateUrl ="http://localhost:8081/auth/venue/"+event_search.getText();
		
		EventVenueResponse eventResponse = RestUtil.sendPostRequest(updateUrl, EventVenueResponse.class, eventRequest);
		
		if(eventResponse.getMessage().equals("Failed")) {
			System.out.println("User update failed" + eventResponse.getMessage());
			
		}
		else {
			System.out.println("User updated successfully");
		}
		
	}
	
	public void back(ActionEvent event) throws IOException{
		try {
			HomeScreen.showHomeScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Logout(ActionEvent event)throws IOException
{
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

	public void Search(ActionEvent event) throws IOException, InterruptedException{
		String SearchQuery ="http://localhost:8081/auth/venue/" + event_search.getText();
		EventVenueResponse eventResponse = RestUtil.sendGetRequest(SearchQuery,EventVenueResponse.class);
		
		if(eventResponse.getMessage().equals("Fail")) {
			System.out.println("User not found");
		}
		else {
			 EventVenueRequest eventData = eventResponse.getEventData();
			 EventType.setText(eventData.getEventType());
			 Capacity.setText(eventData.getCapacity());
			 Cost.setText(eventData.getCost());
			 Location.setText(eventData.getLocation());
			 Contacts.setText(eventData.getContacts());
			 Date.setText(eventData.getDate());
			 ItemName.setText(eventData.getItemName());
			 ItemCost.setText(eventData.getItemCost());
			 EquipmentName.setText(eventData.getEquipmentName());
			 EquipmentCost.setText(eventData.getEquipmentCost());
			 System.out.println("User found !!");
		}
		
		}
}
