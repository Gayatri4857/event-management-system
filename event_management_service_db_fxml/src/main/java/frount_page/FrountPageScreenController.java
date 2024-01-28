package frount_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login_screen.LoginScreen;

public class FrountPageScreenController {

	@FXML
	private Button start;
	
	public void start_button(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
