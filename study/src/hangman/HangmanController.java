package hangman;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HangmanController {
	
	@FXML
	private TextField quiz;
	
	private String hiddenVoca;
	private String visibleVoca;
	
	@FXML
	public void searchHangman(ActionEvent event) {
		Button btn = (Button) event.getSource();
		String alphabet = btn.getText();
		
		if (hiddenVoca == null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("알림");
			alert.setHeaderText(null);
			alert.setContentText("시작을 눌러 게임을 시작해주십시오.");
			alert.showAndWait();
		}
		
		quiz.setText("");
		
		String[] visibleTemArr = new String[visibleVoca.length()];
		
		for (int i=0; i<visibleVoca.length(); i++) {
			visibleTemArr[i] = visibleVoca.substring(i, i+1);
		}
		
		for (int i=0; i<hiddenVoca.length(); i++) {
			if (alphabet.equals(hiddenVoca.substring(i, i+1))) {
				visibleTemArr[i] = alphabet;
			}
		}

		visibleVoca = "";		
		
		for (int i=0; i<hiddenVoca.length(); i++) {
			visibleVoca += visibleTemArr[i];
		}
		
		quiz.setText(visibleVoca);
		
		if (hiddenVoca.equals(visibleVoca)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림");
			alert.setHeaderText(null);
			alert.setContentText("승리하셨습니다!");
			alert.showAndWait();
			hiddenVoca = null;
			visibleVoca = null;
			quiz.setText("");
		}
	}
	
	@FXML
	public void startProgram() {
		quiz.setText("");
		hiddenVoca = "";
		visibleVoca = "";
		
		try {
			ArrayList<String> voca = new HangmanDAO().getHangmanVocaburaly();
			Collections.shuffle(voca);
			
			hiddenVoca = voca.get(0);
			for (int i=0; i<voca.get(0).length(); i++) {
				visibleVoca += "-";
				quiz.setText(visibleVoca);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void endProgram() {
		
	}
}
