package file.demo;

public class BookApp {
	public static void main(String[] args) throws Exception {
		
		Book book = new Book("십이국기", "오노 후유미", "신조사", 8000);
		BookStore bs = new BookStore();
		
		bs.addBook(book);
		bs.displayBooks();
		bs.saveBooks();
	}
}
