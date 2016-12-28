package sample4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolApp7 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		CourseDAO dao = new CourseDAO();
		System.out.println("교수번호를 입력하세요:");
		int no = Integer.parseInt(sc.nextLine());
		
		ArrayList<CourseVO> courseList = dao.getCourseListByProNo(no); 
		for (CourseVO course : courseList) {
			StudentVO stu = course.getStudent();
			SubjectVO sub = course.getSubject();
			
			System.out.printf("%d %s %d %s %s %d %d %s %s %d\n",
					sub.getProfessor().getNo(), sub.getProfessor().getName(),
					stu.getNo(), stu.getName(), stu.getMajor(), stu.getGrade(),
					sub.getNo(), sub.getName(), sub.getType(), sub.getLimit());
		}
		
		sc.close();
	}
}
