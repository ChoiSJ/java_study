package sample3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookApp3 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("검색할 책의 제목을 입력하세요:");
		String resultTitle = sc.nextLine();
		
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> books = dao.searchBooksByTitle(resultTitle);
		for (BookVO book : books) {
			int no = book.getNo();
			String title = book.getTitle();
			String author = book.getAuthor();
			String publisher = book.getPublisher();
			int price = book.getPrice();
			
			System.out.println(no + ", " + title + ", " + author + ", " + price + ", " + publisher);
		}
		
		sc.close();
	}
}
