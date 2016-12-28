package sample3;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("최소가격을 입력하세요:");
		int minPrice = Integer.parseInt(sc.nextLine());
		System.out.println("최대가격을 입력하세요:");
		int maxPrice = Integer.parseInt(sc.nextLine());
		
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> books = dao.searchBookByPrice(minPrice, maxPrice);
		
		for (BookVO vo : books) {
			int no = vo.getNo();
			String title = vo.getTitle();
			String author = vo.getAuthor();
			String publisher = vo.getPublisher();
			int price = vo.getPrice();
			System.out.println(no + ", " + title + ", " + author + ", " + price + ", " + publisher);
		}
	}
}
