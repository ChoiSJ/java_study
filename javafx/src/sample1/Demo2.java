package sample1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Demo2 extends Application {

	/*
	 * 레이아웃(Layout)은 컨트롤의 배치를 책임진다.
	 * 레이아웃은 다양한 방법으로 여러 개의 컨트롤을 포함할 수 있다.
	 * 장면(Scene)은 레이아웃(컨테이너)을 지정해서 만든다.
	 * 장면(Scene)을 생성해서 stage 에 설정하기
	 */
	
	@Override
	public void start(Stage primaryStage) {
		VBox rootLayout = new VBox();			// 루트 컨테이너 설정
		rootLayout.setPrefWidth(350);			// 너비 설정
		rootLayout.setPrefHeight(150);			// 높이 설정
		rootLayout.setAlignment(Pos.CENTER);	// 컨트롤의 정렬방법 설정
		rootLayout.setSpacing(20.0);			// 컨트롤간의 간격 지정
		
		// 라벨 컨트롤 생성
		Label label = new Label("Hello, javafx");
		label.setFont(new Font(50));
		
		// 버튼 컨트롤 생성
		Button btn = new Button("확인");
		btn.setOnAction((event) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("정보");
			alert.setHeaderText("간단 안내 사항");
			alert.setContentText("확인버튼이 클릭되었습니다.");
			
			alert.showAndWait();
		});
		
		// 루트컨테이너에 컨트롤 추가하기
		rootLayout.getChildren().add(label);
		rootLayout.getChildren().add(btn);
		
		// 장면을 생성한다.
		// 장면은 UI 컨트롤이 추가된 layout 객체가 필요하다.
		Scene scene = new Scene(rootLayout);
		
		// 메인 윈도우에 장면을 붙인다
		primaryStage.setScene(scene);
		primaryStage.setTitle("첫번째 프로그램");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
