package sample1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Demo3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox rootLayout = new HBox();
		rootLayout.setPadding(new Insets(10));	// 안쪽 여백 설정
		rootLayout.setSpacing(10.0);			// 컨트롤간 수평 간격 설정
		
		TextField textfield = new TextField();
		textfield.setPrefWidth(200);
		
		Button btn = new Button("확인");
		
		rootLayout.getChildren().add(textfield);
		rootLayout.getChildren().add(btn);
		
		Scene scene = new Scene(rootLayout);
		
		primaryStage.setTitle("Demo3 Layout");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
