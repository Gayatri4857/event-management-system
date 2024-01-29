package register_screen;

import java.io.IOException;

import add_event.AddEvent;
import common.RestUtil;
import dto.UserRequest;
import dto.UserResponse;
import frount_page.FrountPage;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login_screen.LoginScreen;

public class RegisterScreenController {

	@FXML
	private TextField Username;
	
	@FXML
	private TextField Email;
	
	@FXML
	private TextField Password;
	
	@FXML
	private TextField Mobile_no;
	
	@FXML
	private Button register_button;
	
	@FXML
	private Button cancel_button;
	
	@FXML
	private Button Home;
	
	public void Home_Button(ActionEvent event)throws IOException{
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void register_button(ActionEvent event) throws IOException, InterruptedException{
		
		UserRequest addUserRequest = new UserRequest();
		
		addUserRequest.setUsername(Username.getText());
		addUserRequest.setPassword(Password.getText());
		addUserRequest.setEmail(Email.getText());
		addUserRequest.setMobile_no(Mobile_no.getText());
		
		try {
			UserResponse response = RestUtil.sendPostRequest("http://localhost:8081/auth/user",UserResponse.class, addUserRequest);
			System.out.println("User Added Successfully");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			HomeScreen.showHomeScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancel_button(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
