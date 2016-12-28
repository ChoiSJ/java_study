package sample4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolApp5 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		CourseDAO dao = new CourseDAO();
		System.out.println("학생번호를 입력하세요:");
		int stuNo = Integer.parseInt(sc.nextLine());
		
		ArrayList<CourseVO> courseList = dao.getCourseListByStuNo(stuNo);
		for (CourseVO course : courseList) {
			StudentVO stu = course.getStudent();
			SubjectVO sub = course.getSubject();
		
			System.out.printf("%d %s %s %s %s %d %s %d %s\n",
							stu.getNo(), stu.getName(), stu.getMajor(), stu.getPhone(), stu.getId(),
							sub.getNo(), sub.getName(), sub.getLimit(), sub.getType());
		}
		
		sc.close();
	}
}
