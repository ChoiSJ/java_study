package hangman;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HangmanController {
	
	@FXML
	private TextField quiz;
	
	@FXML
	private ImageView hangmanImage;
	
	private String hiddenVoca;
	private String visibleVoca;
	private int index;
	
	@FXML
	public void searchHangman(ActionEvent event) {
		Button btn = (Button) event.getSource();
		String alphabet = btn.getText();
		
		if (hiddenVoca == null || visibleVoca == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림");
			alert.setHeaderText(null);
			alert.setContentText("시작을 눌러 게임을 시작해주십시오.");
			alert.showAndWait();
			return;
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
		
		String visibleVocaTem = visibleVoca;
		visibleVoca = "";
		
		for (int i=0; i<hiddenVoca.length(); i++) {
			visibleVoca += visibleTemArr[i];
		}
		
		if (visibleVoca.equals(visibleVocaTem)) {
			index++;
			
			if (index == 1) {
				Image image = new Image("File:hangman1.png");
				hangmanImage.setImage(image);
			} else if (index == 2) {
				Image image = new Image("File:hangman2.png");
				hangmanImage.setImage(image);
			} else if (index == 3) {
				Image image = new Image("File:hangman3.png");
				hangmanImage.setImage(image);
			} else if (index == 4) {
				Image image = new Image("File:hangman4.png");
				hangmanImage.setImage(image);
			} else if (index == 5) {
				Image image = new Image("File:hangman5.png");
				hangmanImage.setImage(image);
			} else if (index == 6) {
				Image image = new Image("File:hangman6.png");
				hangmanImage.setImage(image);
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("알림");
				alert.setHeaderText(null);
				alert.setContentText("패배하셨습니다.");
				alert.showAndWait();
				
				quiz.setText(hiddenVoca);
				index = 0;
				hiddenVoca = null;
				visibleVoca = null;
				return;
			}
			
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
			index = 0;
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
			
			Image image = new Image("File:hangmanDefault.png");
			hangmanImage.setImage(image);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void endProgram() {
		Platform.exit();
	}
}
