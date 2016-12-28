package sample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("사원아이디를 입력하세요.");
		int id = Integer.parseInt(sc.nextLine());
		
		String sql = "select * from employees where employee_id = ?";
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int employeeId = rs.getInt("employee_id");
			String firstName = rs.getString("first_name");
			String jobId = rs.getString("job_id");
			double salary = rs.getDouble("salary");
			double commission = rs.getDouble("commission_pct");
			
			System.out.printf("%d, %s, %s, %f, %f\n", employeeId, firstName, jobId, salary, commission);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		sc.close();
	}
}
