package add_event;

import java.io.IOException;

import common.RestUtil;
import dto.EventVenueRequest;
import dto.EventVenueResponse;
import frount_page.FrountPage;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddEventScreenController {
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
	private Button Add_Button;
	
	@FXML
	private Button Logout_Button;
	
	@FXML
	private Button next_button;
	
	
	
	public void Add(ActionEvent event) throws IOException {
		EventVenueRequest addEventRequest = new EventVenueRequest();
		
		addEventRequest.setEventType(EventType.getText());
		addEventRequest.setCapacity(Capacity.getText());
		addEventRequest.setContacts(Contacts.getText());
		addEventRequest.setItemName(ItemName.getText());
		addEventRequest.setCost(Cost.getText());
		addEventRequest.setDate(Date.getText());
		addEventRequest.setEquipmentCost(EquipmentCost.getText());
		addEventRequest.setEquipmentName(EquipmentName.getText());
		addEventRequest.setItemCost(ItemCost.getText());
		addEventRequest.setLocation(Location.getText());
		
		try {
			EventVenueResponse response = RestUtil.sendPostRequest("http://localhost:8081/auth/venue",EventVenueResponse.class, addEventRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Event Added Successfully !!");
		
	}
	
	public void Logout(ActionEvent event) {
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Next(ActionEvent event) {
		try {
			HomeScreen.showHomeScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
