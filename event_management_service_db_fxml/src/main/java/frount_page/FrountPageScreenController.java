package frount_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login_screen.LoginScreen;

public class FrountPageScreenController {

	@FXML
	private Button start;
	
	@FXML
	private Button Login;
	
	public void start_button(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login_button(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
