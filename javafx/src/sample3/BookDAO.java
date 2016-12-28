package sample3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionUtil;

public class BookDAO {
	
	public void insertBook(BookVO book) throws SQLException {
		String sql = "insert into tb_book (no, title, author, publisher, price, pubdate) "
				+ "values (book_seq.nextval, ?, ?, ?, ?, sysdate) ";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPubilsher());
		pstmt.setInt(4, book.getPrice());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
