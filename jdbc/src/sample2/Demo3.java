package sample2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConnectionUtil;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		String sql = "select count(*) cnt from employees";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println("행의 갯수" + rs.getInt("cnt"));
		}
	}
}
