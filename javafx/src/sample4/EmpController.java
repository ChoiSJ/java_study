package sample4;

import java.sql.SQLException;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class EmpController {
	
	EmpDAO ed = new EmpDAO();
	
	@FXML
	private TextField searchField;
	@FXML
	private TextField empIdField; 
	@FXML
	private TextField empNameField;
	@FXML
	private TextField jobIdField;
	@FXML
	private TextField hireDateField;
	@FXML
	private TextField salaryField;
	@FXML
	private TextField depIdField;
	
	@FXML
	private void search() throws SQLException {
		int empId = Integer.parseInt(searchField.getText());
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("검색 완료");
		alert.setContentText("검색이 완료되었습니다.");
		alert.showAndWait();
		
		EmpVO emp = ed.employee(empId);
		
		empIdField.setText(String.valueOf(emp.getEmpId()));
		empNameField.setText(emp.getEmpName());
		jobIdField.setText(emp.getJobId());
		hireDateField.setText(String.valueOf(emp.getHireDate()));
		
		DecimalFormat df = new DecimalFormat("#,###");
		salaryField.setText(df.format(emp.getSalary()));
		depIdField.setText(String.valueOf(emp.getDepId()));
		
		searchField.setText("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
