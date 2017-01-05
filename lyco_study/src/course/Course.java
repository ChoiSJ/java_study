package course;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseNo;
	private String courseName;
	private int limitedNumber;
	private int maxNumber;
	private Professor pro;
	private ArrayList<Student> stuList = new ArrayList<Student>(maxNumber);
	
	public Course() {}

	public int getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getLimitedNumber() {
		return limitedNumber;
	}
	public void setLimitedNumber(int limitedNumber) {
		this.limitedNumber = limitedNumber;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public Professor getPro() {
		return pro;
	}
	public void setPro(Professor pro) {
		this.pro = pro;
	}
	public ArrayList<Student> getStuList() {
		return stuList;
	}
	public void setStuList(ArrayList<Student> stuList) {
		this.stuList = stuList;
	}
}
