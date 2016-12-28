package sample3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

/**
 * TB_BOOK 테이블을 대상으로 하는 액세스 작업에 구현된 클래스다.
 * @author 최승준
 */
public class BookDAO {
	/**
	 * 새로운 책 정보를 전달받아서 tb_book 테이블에 저장한다.
	 * @param book 추가할 책 정보를 저장하는 Book 객체
	 * @throws SQLException
	 */
	
	public void addBook(BookVO book) throws SQLException {
		String sql = "insert into tb_book"
				+ " (no, title, author, publisher, price, pubdate)"
				+ " values(book_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<BookVO> searchBookByPrice(int min, int max) throws SQLException {
		String sql = "select no, title, author, publisher, price, pubdate"
				+ " from tb_book"
				+ " where price >= ? and price <= ?"
				+ " order by no asc";
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, min);
		pstmt.setInt(2, max);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BookVO book = new BookVO();
			book.setNo(rs.getInt("no"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("publisher"));
			book.setPrice(rs.getInt("price"));
			book.setPubdate(rs.getDate("pubdate"));
			
			bookList.add(book);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return bookList;
	}
	
	public ArrayList<BookVO> searchBooksByTitle(String title) throws SQLException {
		String sql = "select no, title, author, publisher, price, pubdate"
				+ " from tb_book"
				+ " where title like '%' || ? || '%'";
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BookVO book = new BookVO();
			book.setNo(rs.getInt("no"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("publisher"));
			book.setPrice(rs.getInt("price"));
			book.setPubdate(rs.getDate("pubdate"));
			
			bookList.add(book);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return bookList;
	}
}
