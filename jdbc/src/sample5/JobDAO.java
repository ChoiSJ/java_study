package sample5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import util.ConnectionUtil;
import util.QueryUtil;

public class JobDAO {
	public ArrayList<Job> getJobsBySalary(int salary) throws SQLException {
		ArrayList<Job> jobList = new ArrayList<Job>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			pstmt = con.prepareStatement(QueryUtil.getSql("getJobBySalary"));
			pstmt.setInt(1, salary);
			pstmt.setInt(2, salary);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMin(rs.getInt("min_salary"));
				job.setMax(rs.getInt("max_salary"));
			}
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return jobList;
	}
}
