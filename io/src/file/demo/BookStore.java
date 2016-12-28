package file.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookStore {
	
	ArrayList<Book> bookList = new ArrayList<Book>();
	BufferedReader fd = new BufferedReader(new FileReader("books.txt"));
	
	public BookStore() throws IOException {
		loadBookData();
	}
	
	private void loadBookData() throws IOException {
		// books.txt 파일을 읽어서 책 정보를 ArrayList 에 담기
		String text = null;
		while ((text=fd.readLine()) != null) {
			String[] arr = text.split(",");
			Book book = new Book();
			book.setTitle(arr[0]);
			book.setAuthor(arr[1]);
			book.setPublisher(arr[2]);
			book.setPrice(Integer.parseInt(arr[3]));
			
			addBook(book);
		}
	}
	
	public void displayBooks() {
		// ArrayList 에 저장된 책 정보를 화면에 출력하기
		for (Book book : bookList) {
			System.out.println("제  목:" + book.getTitle());
			System.out.println("저  자:" + book.getAuthor());
			System.out.println("출판사:" + book.getPublisher());
			System.out.println("가  격:" + book.getPrice());
		}
	}
	
	public void addBook(Book book) {
		// 전달받은 책 정보를 ArrayList 에 저장하기
		bookList.add(book);
	}
	
	public void saveBooks() throws IOException {
		// ArrayList 에 저장된 책 정보를 books.txt 파일에 저장하기(덮어쓰기)
		PrintWriter writer = new PrintWriter(new FileWriter("new books.txt"), true);
		
		for (Book book : bookList) {
			String[] arr = new String[4];
			arr[0] = "제  목:" + book.getTitle();
			arr[1] = "저  자:" + book.getAuthor();
			arr[2] = "출판사:" + book.getPublisher();
			arr[3] = "가  격:" + String.valueOf(book.getPrice());
			
			for (String info : arr) {
				writer.println(info);
			}
		}	
		
		writer.close();
	}
}
