package sample6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class HRDao {
	
	static final String GET_ALL_DEPTS = "select * "
									+ "from departments "
									+ "order by department_id ";
	
	static final String GET_EMP_BY_DEPT = "select * "
									+ "from employees "
									+ "where department_id = ? "
									+ "order by employee_id ";
	
	static final String GET_EMP_BY_ID = "select * "
									+ "from employees "
									+ "where employee_id = ? ";
	
	public ArrayList<Dept> getAllDepts() throws SQLException {
		ArrayList<Dept> deptList = new ArrayList<Dept>();
			
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_ALL_DEPTS);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Dept dept = new Dept();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			
			deptList.add(dept);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return deptList;
	}
	
	public ArrayList<Emp> getEmpsByDept(int deptId) throws SQLException {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_EMP_BY_DEPT);
		pstmt.setInt(1, deptId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setId(rs.getInt("employee_id"));
			emp.setName(rs.getString("first_name"));
			emp.setJob(rs.getString("job_id"));
			emp.setSalary(rs.getInt("salary"));
			
			empList.add(emp);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return empList;
	}
	
	public Emp getEmpById(int empId) throws SQLException {
		Emp emp = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_EMP_BY_ID);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			emp = new Emp();
			emp.setId(rs.getInt("employee_id"));
			emp.setName(rs.getString("first_name"));
			emp.setJob(rs.getString("job_id"));
			emp.setSalary(rs.getInt("salary"));
		}
		
		return emp;
	}
}
