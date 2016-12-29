package sample6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HRController {
	
	private HRDao dao = new HRDao();
	
	@FXML
	private TableView<Dept> deptTable;
	@FXML
	private TableView<Emp> empTable;
	@FXML
	private TableColumn<Dept, Number> deptIdColumn;
	@FXML
	private TableColumn<Dept, String> deptNameColumn;
	@FXML
	private TableColumn<Emp, Number> empIdColumn;
	@FXML
	private TableColumn<Emp, String> empNameColumn;
	@FXML
	private TableColumn<Emp, String> empJobColumn;
	@FXML
	private TableColumn<Emp, Number> empSalaryColumn;
	
	private ObservableList<Dept> deptData = FXCollections.observableArrayList();
	private ObservableList<Emp> empData = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() throws SQLException {
		deptIdColumn.setCellValueFactory(celldata -> celldata.getValue().idProperty());
		deptNameColumn.setCellValueFactory(celldata -> celldata.getValue().nameProperty());
		
		empIdColumn.setCellValueFactory(celldata -> celldata.getValue().idProperty());
		empNameColumn.setCellValueFactory(celldata -> celldata.getValue().nameProperty());
		empJobColumn.setCellValueFactory(celldata -> celldata.getValue().jobProperty());
		empSalaryColumn.setCellValueFactory(celldata -> celldata.getValue().salaryProperty());
		
		deptTable.getSelectionModel().selectedItemProperty()
			.addListener((obserable, oldValue, newValue) -> {
				int deptId = newValue.getId();
				
				empData.clear();
				
				try {
					ArrayList<Emp> empList = dao.getEmpsByDept(deptId);
					empData.addAll(empList);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		});
		
		empTable.getSelectionModel().selectedItemProperty()
			.addListener((observable, oldValue, newValue) -> {
				if (newValue != null) {
					int empId = newValue.getId();
					
					try {
						Emp emp = dao.getEmpById(empId);
						
						if (emp != null) {
							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(HRController.class.getResource("Emp.fxml"));
							Parent page = loader.load();
							
							Scene scene = new Scene(page);
							
							Stage dialogStage = new Stage();
							dialogStage.setTitle("상세 정보 픽업");
							dialogStage.setScene(scene);
							dialogStage.initModality(Modality.WINDOW_MODAL);
							
							EmpController controller = loader.getController();
							controller.setDialogStage(dialogStage);
							controller.setEmp(emp);
							controller.displayEmpInfo();
							
							dialogStage.showAndWait();
						}
						
					} catch (SQLException | IOException e) {
						e.printStackTrace();
					}
				}
		});
		
		ArrayList<Dept> deptList = dao.getAllDepts();
		deptData.addAll(deptList);
		
		deptTable.setItems(deptData);
		empTable.setItems(empData);
	}
}
