package sample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		String sql = "insert into tb_book(no, title, author, publisher, price, pubdate)"
				+ "values(book_seq.nextval, ?, ?, ?, ?, sysdate)";
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "이것이 자바다");
		pstmt.setString(2, "신용권");
		pstmt.setString(3, "한빛미디어");
		pstmt.setInt(4, 35000);
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "개의 행이 추가되었습니다.");
		
		pstmt.close();
		con.close();
	}
}
