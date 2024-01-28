package register_screen;
import java.net.URL;
import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RegisterScreen {
public static void showRegisterScreen() throws Exception{
	try {
		Parent actorGroup = FXMLLoader.load(new URL("file:///C:\\\\\\\\Users\\\\\\\\hemag\\\\\\\\eclipse-workspace\\\\\\\\/event-management-service-jfx-db/src/main/java/register_screen/RegistrationPage_EventBookingSystem.fxml"));
		StageFactory.stage.setTitle("Customer Login");
		Scene scene = new Scene(actorGroup,1000,400);
		StageFactory.stage.setScene(scene);
		StageFactory.stage.setFullScreen(true);
		StageFactory.stage.show();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
