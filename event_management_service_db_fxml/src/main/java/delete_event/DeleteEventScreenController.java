package delete_event;

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

public class DeleteEventScreenController {
	
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
	private Button Delete_Button;
	
	@FXML
	private Button Logout_Button;
	
	@FXML
	private Button Back;
	
	@FXML
	private Button Search;
	
	public void Delete(ActionEvent event) throws IOException, InterruptedException{
		
		String deleteURL ="http://localhost:8081/auth/venue/"+event_search.getText();
		
		EventVenueResponse eventvenueResponse = RestUtil.sendDeleteRequest(deleteURL,EventVenueResponse.class);
		
		if(eventvenueResponse.getMessage().equals("Success")) {
			System.out.println("Event Deleted Successfully!!");
		}
		else {
			System.out.println("Not deleted Event !!");
		}
	}
	
	public void Logout(ActionEvent event) throws IOException{
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void Search_Button(ActionEvent event)throws IOException, InterruptedException{
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
