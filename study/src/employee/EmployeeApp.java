package employee;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeApp {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 사원 아이디를 입력하세요:");
		int no = Integer.parseInt(sc.nextLine());
		
		EmployeeDAO edao = new EmployeeDAO();
		EmployeeVO emp = edao.searchEmployeeById(no);
		System.out.printf("%d %s %s %f", emp.getEmployeeId(), emp.getName(), emp.getHireDate(), emp.getSalary());
		
		sc.close();
	}
}
