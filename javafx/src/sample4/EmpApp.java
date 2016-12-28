package sample4;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmpApp extends Application {
	
	@Override
	public void start(Stage primaryStage) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("EmpSearch.fxml"));
			Parent rootLayout = loader.load();
			
			Scene scene = new Scene(rootLayout);
			
			primaryStage.setTitle("사원 검색 프로그램");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	} 
}
