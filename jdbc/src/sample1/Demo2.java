package sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		
		String sql =  "delete from tb_book where no = 100";
		int result = stmt.executeUpdate(sql);
		System.out.println(result + "개의 행이 삭제되었습니다.");
		
		stmt.close();
		con.close();
	}
}
