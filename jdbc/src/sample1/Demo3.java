package sample1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.10.101:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		
		String sql = "select * from tb_book order by no asc";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			int noValue = rs.getInt("no");
			String titleValue = rs.getString("title");
			String authorValue = rs.getString("author");
			String publisherValue = rs.getString("publisher");
			int priceValue = rs.getInt("price");
			Date pubdateValue = rs.getDate("pubdate");
			
			System.out.println(noValue + ", " + titleValue + ", " + 
							authorValue + ", " + publisherValue+ ", " + priceValue + ", " + pubdateValue);
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}
