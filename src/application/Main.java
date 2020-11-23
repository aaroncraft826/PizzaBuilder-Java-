package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import java.util.ArrayList;


/**
 * Main Class that launches the primary stage for CustomerGUI
 * @author Aaron Galang, Marko Elez
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/CustomerGUI.fxml"));
			Scene scene = new Scene(root,550,620);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CustomerGUI");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
