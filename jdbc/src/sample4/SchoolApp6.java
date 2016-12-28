package sample4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolApp6 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		CourseDAO dao = new CourseDAO();
		System.out.println("과목번호를 입력하세요:");
		int no = Integer.parseInt(sc.nextLine());
		
		ArrayList<CourseVO> courseList = dao.getCourseListBySubNo(no);
		for (CourseVO course : courseList) {
			StudentVO stu = course.getStudent();
			SubjectVO sub = course.getSubject();
		
			System.out.printf("%d %s %s %d %d %s %s %d %d %s\n",
							stu.getNo(), stu.getName(), stu.getMajor(), stu.getGrade(),
							sub.getNo(), sub.getName(), sub.getType(), sub.getLimit(),
							sub.getProfessor().getNo(), sub.getProfessor().getName());
		}
		
		sc.close();
	}
}
