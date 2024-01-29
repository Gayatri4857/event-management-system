package search_user;

import java.io.IOException;

import common.RestUtil;
import dto.UserData;
import dto.UserResponse;
import frount_page.FrountPage;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchUserScreenController {

	@FXML
	private TextField nameToSearch;
	
	@FXML
	private TextField UserName;
	
	@FXML
	private TextField Email;
	
	@FXML
	private TextField MobileNumber;
	
	@FXML
	private TextField UserRole;
	
	@FXML
	private Button SearchButton;
	
	@FXML
	private Button BackButton;
	
	@FXML
	private Button LogoutButton;
	
	public void Search(ActionEvent event) throws IOException, InterruptedException {


			String searchUrl = "http://localhost:8081/auth/user/search/" + nameToSearch.getText();

			UserResponse userResponse = RestUtil.sendGetRequest(searchUrl, UserResponse.class);

			if (userResponse.getStatus().equals("fail")) {
				System.out.println("!!!!USER NOT FOUND!!!!!");
			} else {
				UserData userData = userResponse.getUserData();
				UserName.setText(userData.getUsername());
				Email.setText(userData.getEmail());
				MobileNumber.setText(userData.getMobile_no());
				UserRole.setText(userData.getRole());
				Email.setText(userData.getEmail());
				
				System.out.println("User Found");
			}
	}
	
	public void back(ActionEvent event) {
		try {
			HomeScreen.showHomeScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Logout(ActionEvent event) {
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
