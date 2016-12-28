package sample4;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentApp1 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		StudentVO stu = new StudentVO();
		System.out.println("이름을 입력하세요:");
		stu.setName(sc.nextLine());
		System.out.println("전공을 입력하세요:");
		stu.setMajor(sc.nextLine());
		System.out.println("학년을 입력하세요:");
		stu.setGrade(Integer.parseInt(sc.nextLine()));
		System.out.println("전화번호를 입력하세요:");
		stu.setPhone(sc.nextLine());
		System.out.println("아이디를 입력하세요:");
		stu.setId(sc.nextLine());
		System.out.println("비밀번호를 입력하세요:");
		stu.setPassword(sc.nextLine());
		
		dao.addNewStudent(stu);
		sc.close();
	}
}
