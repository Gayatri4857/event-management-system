package event_management_main;

import common.StageFactory;
import frount_page.FrountPage;
import javafx.application.Application;
import javafx.stage.Stage;


public class ApplicationMain extends Application {
	public static void main(String args[]) {
		launch(args);
	}
	@Override
	public void start(Stage stage) {

		StageFactory.stage = stage;
		try {
			FrountPage.showFrountPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
