package feedback_screen;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddFeedBackScreen {
	
public static void showAddFeedBackScreen() {
	try {
					
       Parent actorGroup=FXMLLoader.load(new URL("file:///C:\\Users\\hemag\\eclipse-workspace\\event-management-service-jfx-db\\src\\main\\java\\feedback_screen\\Feedback_Screen.fxml"));
			StageFactory.stage.setTitle("AddFeedBack Screen");
			Scene scene=new Scene(actorGroup,600,400);
		    StageFactory.stage.setScene(scene);
		    StageFactory.stage.setFullScreen(true);;
		    StageFactory.stage.show();
					
					
	}catch (Exception e){
			e.printStackTrace();
	}
}
}










