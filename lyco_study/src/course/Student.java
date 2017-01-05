package course;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int stuNo;
	private String name;
	private String major;
	private int grade;
	private String stuId;
	private String stuPassword;
	
	public Student() {}
	
	public Student(int stuNo, String name, String major, int grade, String stuId, String stuPassword) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.stuId = stuId;
		this.stuPassword = stuPassword;
	}
	
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
}
