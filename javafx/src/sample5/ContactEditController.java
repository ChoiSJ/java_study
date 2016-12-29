package sample5;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContactEditController {
	
	private ObservableList<Contact> contactData;
	private Stage dialogStage;
	
	public void setContactData(ObservableList<Contact> contactData) {
		this.contactData = contactData;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField addrField;
	@FXML
	private TextField faxField;
	
	@FXML
	public void registerContact() {
		String name = nameField.getText();
		String phone = phoneField.getText();
		String email = emailField.getText();
		String addr = addrField.getText();
		String fax = faxField.getText();
		
		Contact contact = new Contact();
		contact.setName(name);
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setAddr(addr);
		contact.setFax(fax);
		
		contactData.add(contact);
		
		dialogStage.close();
	}
	
	@FXML
	public void cancal() {
		
	}
}
