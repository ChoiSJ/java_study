package sample5;

import java.text.DecimalFormat;
import java.util.Date;

public class Emp {
	private int id;
	private String firstName;
	private Date hireDate;
	private double salary;
	private String jobId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getSalaryWithComma() {
		DecimalFormat df = new DecimalFormat("##,###");
		return df.format(salary);
	}
}
