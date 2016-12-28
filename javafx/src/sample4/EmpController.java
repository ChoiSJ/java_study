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
		try {
			int empId = Integer.parseInt(searchField.getText());
			EmpVO emp = ed.employee(empId);
			
			if (emp == null) {
				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setTitle("검색 완료");
				alert1.setHeaderText(null);
				alert1.setContentText("검색 결과가 없습니다.");
				alert1.showAndWait();
				clear();
				return;
			}
			
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("검색 완료");
			alert2.setHeaderText(null);
			alert2.setContentText("검색이 완료되었습니다.");
			alert2.showAndWait();
			
			empIdField.setText(String.valueOf(emp.getEmpId()));
			empNameField.setText(emp.getEmpName());
			jobIdField.setText(emp.getJobId());
			hireDateField.setText(String.valueOf(emp.getHireDate()));
			
			DecimalFormat df = new DecimalFormat("#,###");
			salaryField.setText(df.format(emp.getSalary()));
			depIdField.setText(String.valueOf(emp.getDepId()));
			
			searchField.setText("");
		} catch (NumberFormatException e) {
			Alert alert3 = new Alert(AlertType.ERROR);
			alert3.setTitle("검색 완료");
			alert3.setHeaderText(null);
			alert3.setContentText("잘못된 입력입니다.");
			alert3.showAndWait();
			clear();
		}
	}
	
	private void clear() {
		searchField.setText("");
		empIdField.setText("");
		empNameField.setText("");
		jobIdField.setText("");
		hireDateField.setText("");
		salaryField.setText("");
		depIdField.setText("");
	}
}
