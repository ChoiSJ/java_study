package sample4;

import java.util.ArrayList;

public class SchoolApp4 {
	public static void main(String[] args) throws Exception {
		
		CourseDAO dao = new CourseDAO();
		ArrayList<CourseVO> courseList = dao.getAllCourseList();
		
		for (CourseVO course : courseList) {
			StudentVO st = course.getStudent();
			SubjectVO su = course.getSubject();
			
			System.out.printf("%d %s %s %d %d %s %s %d\n",
							st.getNo(), st.getName(), st.getMajor(), st.getGrade(),
							su.getNo(), su.getName(), su.getType(), su.getLimit());
		}
	}
}
