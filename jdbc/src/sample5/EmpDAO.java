package sample5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import util.QueryUtil;

public class EmpDAO {
	public ArrayList<Emp> getAllEmployees() throws SQLException {
		ArrayList<Emp> employees = new ArrayList<Emp>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getConnection();
			pstmt = con.prepareStatement(QueryUtil.getSql("getAllEmployees"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hire_date"));
				
				employees.add(emp);
			}
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return employees;
	}
}
