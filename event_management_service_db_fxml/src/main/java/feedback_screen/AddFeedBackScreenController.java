package feedback_screen;

import java.io.IOException;

import common.RestUtil;
import dto.FeedBackRequest;
import dto.FeedBackResponse;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddFeedBackScreenController {

	@FXML
	private Button Submit;
	
	@FXML
	private Button Home;
	
	@FXML
	private Button Sad;
	
	@FXML
	private Button Medium;
	
	@FXML
	private Button Good;
	
	@FXML
		private  TextField FeedBack;
		
		@FXML
		private  TextField UserName;
		
		@FXML
		private  TextField Email;
		
		 public void Submit(ActionEvent event) throws IOException, InterruptedException {
		        
		        FeedBackRequest newfeedback = new FeedBackRequest();
		        newfeedback .setUsername(UserName.getText()); // Set the event name
		        newfeedback .setFeedBack(FeedBack.getText());
		        newfeedback .setEmail(Email.getText());// Set the event cost
		      
			        try {
						FeedBackResponse response=RestUtil.sendPostRequest("http://localhost:8081/auth/feedback", FeedBackResponse.class,newfeedback);
						

					} catch (Exception e) {
						
						e.printStackTrace();
					}
			        
			  try {
				HomeScreen.showHomeScreen();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
		 

	public void home_button(ActionEvent event) {
		try {
			HomeScreen.showHomeScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Sad(ActionEvent event) {
		
	}
	
    public void Medium(ActionEvent event) {
		
	}

   public void Good(ActionEvent event) {
	
}
}





			
			
			
			
			



				
						
		  			
						
		  	
						
					
				  

			
				  		

				
				
								