package hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HangmanDAO {
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
	public ArrayList<String> getHangmanVocaburaly() throws SQLException {
		ArrayList<String> voca = new ArrayList<String>();
		String sql = "select vocaburaly from hangman_voca ";
		
		Connection con = new HangmanDAO().getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String vocaOne = rs.getString("vocaburaly");
			
			voca.add(vocaOne);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return voca;
	} 
}
