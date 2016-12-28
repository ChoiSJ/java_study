package sample4;

import java.util.Date;

public class CourseVO {
	private StudentVO student;
	private SubjectVO subject;
	private Date regdate;
	
	public StudentVO getStudent() {
		return student;
	}
	public void setStudent(StudentVO student) {
		this.student = student;
	}
	public SubjectVO getSubject() {
		return subject;
	}
	public void setSubject(SubjectVO subject) {
		this.subject = subject;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
