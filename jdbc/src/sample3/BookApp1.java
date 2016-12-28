package sample3;

import java.sql.SQLException;
import java.util.Scanner;

public class BookApp1 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("제목을 입력하세요:");
		String title = sc.nextLine();
		System.out.println("저자를 입력하세요:");
		String author = sc.nextLine();
		System.out.println("출판사를 입력하세요:");
		String publisher = sc.nextLine();
		System.out.println("가격을 입력하세요:");
		int price = Integer.parseInt(sc.nextLine());
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);
		
		BookDAO dao = new BookDAO();
		dao.addBook(book);
	}
}
