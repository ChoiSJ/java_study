package sample1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Demo4 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Root.fxml 읽어서 Layout 만들기
		HBox rootLayout = FXMLLoader.load(Demo4.class.getResource("Root.fxml"));
		Scene scene = new Scene(rootLayout);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
