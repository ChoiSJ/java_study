package sample4;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentApp3 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		System.out.println("검색하실 아이디를 입력하세요:");
		String stuId = sc.nextLine();
		
		StudentVO stu = dao.getStudentById(stuId);
		System.out.printf("%d %s %s %d %s %s %s",
				stu.getNo(), stu.getName(), stu.getMajor(), stu.getGrade(), stu.getPhone(), stu.getId(), stu.getPassword());
		sc.close();
	}
}
