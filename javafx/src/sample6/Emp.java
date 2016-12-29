package sample6;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Emp {
	
	private SimpleIntegerProperty idProperty = new SimpleIntegerProperty();
	private SimpleStringProperty nameProperty = new SimpleStringProperty();
	private SimpleStringProperty jobProperty = new SimpleStringProperty();
	private SimpleIntegerProperty salaryProperty = new SimpleIntegerProperty();
	
	public Integer getId() {
		return idProperty.get();
	}
	public void setId(Integer no) {
		this.idProperty.set(no);
	}
	public SimpleIntegerProperty idProperty() {
		return idProperty;
	}
	public String getName() {
		return nameProperty.get();
	}
	public void setName(String name) {
		this.nameProperty.set(name);
	}
	public SimpleStringProperty nameProperty() {
		return nameProperty;
	}
	public String getJob() {
		return jobProperty.get();
	}
	public void setJob(String job) {
		this.jobProperty.set(job);
	}
	public SimpleStringProperty jobProperty() {
		return jobProperty;
	}
	public Integer getSalary() {
		return salaryProperty.get();
	}
	public void setSalary(Integer salary) {
		this.salaryProperty.set(salary);
	}
	public SimpleIntegerProperty salaryProperty() {
		return salaryProperty;
	}
}
