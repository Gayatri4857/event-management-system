package login_screen;

import java.sql.SQLException;

import common.RestUtil;
import dto.LoginRequest;
import dto.LoginResponse;
import frount_page.FrountPage;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import register_screen.RegisterScreen;

public class LoginScreenController {
	
	@FXML
	private TextField Email;

	@FXML
	private TextField Password;

	@FXML
	private Button login_button;
	
	@FXML
	private Button register_button;
	

	public void login_button(ActionEvent event) throws SQLException {

		boolean loginStatus = LoginScreenController.ValidateUserAndPassword(Email.getText(), Password.getText());

		if (loginStatus) {
			try {
				HomeScreen.showHomeScreen();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Login Unsuccessful");
		}
	}
	public static boolean ValidateUserAndPassword(String email, String password) throws SQLException {

		LoginRequest loginRequest = new LoginRequest();
		
		loginRequest.setEmail(email);
		loginRequest.setPassword(password);
	
		LoginResponse response;

		try {
			response = RestUtil.sendPostRequest("http://localhost:8081/auth/validate", LoginResponse.class, loginRequest);

			if (response.getStatus().equals("Success")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void register_button(ActionEvent event) throws SQLException{
		try {
			RegisterScreen.showRegisterScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
