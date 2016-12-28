package sample4;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentApp2 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		System.out.println("검색할 번호를 입력하세요:");
		int stuNo = Integer.parseInt(sc.nextLine());
		StudentVO stu = dao.getStudentByNo(stuNo);
		
		if (stu != null) {
			System.out.printf("%d %s %s %d %s %s %s",
						stu.getNo(), stu.getName(), stu.getMajor(), stu.getGrade(), stu.getPhone(), stu.getId(), stu.getPassword());
		} else if (stu == null) {
			System.out.println("검색 결과 없음");
		}
		
		sc.close();
	}
}
