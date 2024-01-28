package frount_page;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FrountPage {
	public static void showFrountPage() throws Exception{
		try {
			Parent actorGroup = FXMLLoader.load(new URL("file:///C:\\Users\\hemag\\eclipse-workspace\\event-management-service-jfx-db\\src\\main\\java\\frount_page\\Eventmanagenent.fxml"));
			StageFactory.stage.setTitle("Customer Login");
			Scene scene = new Scene(actorGroup,600,400);
			StageFactory.stage.setScene(scene);
			StageFactory.stage.setFullScreen(true);
			StageFactory.stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}
}
