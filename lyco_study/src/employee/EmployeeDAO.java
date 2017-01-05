package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class EmployeeDAO {
	public EmployeeVO searchEmployeeById(int no) throws SQLException {
		String url = "select employee_id, first_name || ' ' || last_name as name, hire_date, salary"
				+ " from employees where employee_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(url);
		
		EmployeeVO emp = new EmployeeVO();
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		emp.setEmployeeId(rs.getInt("employee_id"));
		emp.setName(rs.getString("name"));
		emp.setHireDate(rs.getDate("hire_date"));
		emp.setSalary(rs.getInt("salary"));
				
		pstmt.close();
		con.close();
		return emp;
	}
}