package home_screen;

import java.io.IOException;

import add_event.AddEvent;
import delete_event.DeleteEvent;
import feedback_screen.AddFeedBackScreen;
import frount_page.FrountPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_update_screen.Search_Update_Screen;

public class HomeScreenController {

	@FXML
	private Button Home_Button;
	
	@FXML
	private Button Book_Venue_Button;
	
	@FXML
	private Button Search_Update_Button;
	
	@FXML
	private Button Delete_Button;
	
	@FXML
	private Button Feedback_Button;
	
	@FXML
	private Button Book_Venue;
	
	@FXML
	private Button Search_Update;
	
	@FXML
	private Button Feedback;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button User_Button;
	
	@FXML
	private Button Logout;
	
	public void home_button(ActionEvent event)throws IOException{
		
	}
	
	public void book_venue_button(ActionEvent event)throws IOException{
		try {
			AddEvent.showAddEventScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void search_update_button(ActionEvent event)throws IOException{
		try {
			Search_Update_Screen.showSearchUpdateScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Delete_button(ActionEvent event)throws IOException{
		try {
			DeleteEvent.showDeleteScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void feedback_button(ActionEvent event)throws IOException{
		AddFeedBackScreen.showAddFeedBackScreen();
	}
	
	public void book_venue(ActionEvent event)throws IOException{
		try {
			AddEvent.showAddEventScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void search_update(ActionEvent event)throws IOException{
		
		try {
			Search_Update_Screen.showSearchUpdateScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Delete(ActionEvent event)throws IOException
	{
		try {
			DeleteEvent.showDeleteScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void feendback(ActionEvent event)throws IOException{
		AddFeedBackScreen.showAddFeedBackScreen();
		
	}
	
	public void user_button(ActionEvent event)throws IOException{
		
	}
	public void logout(ActionEvent event)throws IOException{
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
