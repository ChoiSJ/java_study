package sample4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class EmpDAO {
	
	public EmpVO employee(int empId) throws SQLException {
		
		EmpVO emp = null;
		String sql = "select employee_id, first_name || ' ' || last_name as name, "
				+ "job_id, hire_date, salary, department_id "
				+ "from employees where employee_id = ? ";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			emp = new EmpVO();
			emp.setEmpId(rs.getInt("employee_id"));
			emp.setEmpName(rs.getString("name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setSalary(rs.getInt("salary"));
			emp.setDepId(rs.getInt("department_id"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
;		
		return emp;
	}
}
