package sample3;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class BookEditController {
	
	private BookDAO bookDao = new BookDAO();
	
	@FXML
	private TextField titleField;
	@FXML
	private TextField authorField;
	@FXML
	private TextField publisherField;
	@FXML
	private TextField priceField;
	
	@FXML
	private void addBook() throws SQLException {
		// 입력필드의 값 읽어오기
		String title = titleField.getText();
		String author = authorField.getText();
		String publisher = publisherField.getText();
		int price = Integer.parseInt(priceField.getText());
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPubilsher(publisher);
		book.setPrice(price);
		
		// db 에 저장하기
		bookDao.insertBook(book);
		
		// 알림창 표시하기
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("책 등록");
		alert.setContentText("책 등록이 완료되었습니다.");
		alert.showAndWait();
		
		// 입력필드 지우기
		clearField();
	}
	
	@FXML
	private void clearField() {
		titleField.setText("");
		authorField.setText("");
		publisherField.setText("");
		priceField.setText("");
	}
}
