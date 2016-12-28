package kr.jhta.bookstore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

/**
 * <p>도서 대여점의 주요 기능을 구현한 클래스
 * <p>도서 대여점의 회원 가입, 로그인, 로그아웃, 대여, 반납, 조회 기능을 구현하였습니다.
 * @author JHTA
 */

public class BookStore {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();
	
	private Scanner sc = new Scanner(System.in);
	private Customer loginedUser = null;
	
	/**
	 * <p>도서대여점의 기본 생성자
	 * 
	 * <p>객체 생성시 기본적으로 고객 한 명의 정보와 책 10권을 각각 등록한다.
	 */
	
	public BookStore() {
		Customer customer = new Customer();
		customer.setId("gahana");
		customer.setPassword("1234");
		customer.setName("가하나");
		customer.setTel("010-1234-5678");
		customer.setRegdate(new Date());
		customer.setPoint(0);
		
		customerList.add(customer);
		
		bookList.add(new Book(1, "셜민석의 조선왕조 실록", 20000));
		bookList.add(new Book(2, "해리포터와 저주받은 아이", 15000));
		bookList.add(new Book(3, "그럴 때 있으시죠?", 15000));
		bookList.add(new Book(4, "그릿 GRIT", 16000));
		bookList.add(new Book(5, "대통령의 글쓰기", 17000));
		bookList.add(new Book(6, "트랜드 코리아", 18000));
		bookList.add(new Book(7, "부르클린의 소녀", 13500));
		bookList.add(new Book(8, "강성태 66 공부법", 12500));
		bookList.add(new Book(9, "지대넓얕", 17000));
		bookList.add(new Book(10, "미움받을 용기", 13000));
	}
	
	/**
	 * 회원 가입 창을 출력하여 전부 입력 후 고객 정보를 생성한다.
	 */
	
	public void register() {
		Customer customer = new Customer();
		
		System.out.print("고객이름을 입력하세요: ");
		customer.setName(sc.nextLine());
		System.out.print("사용할 아이디를 입력하세요: ");
		String id = sc.nextLine();
		if (isExistId(id)) {
			System.out.println("이미 사용중인 아이디입니다.");
			return;
		}
		customer.setId(id);
		System.out.print("사용할 비밀번호를 입력하세요: ");
		customer.setPassword(sc.nextLine());
		System.out.print("연락처를 입력하세요: ");
		customer.setTel(sc.nextLine());
		System.out.print("이메일을 입력하세요: ");
		customer.setEmail(sc.nextLine());
		customer.setRegdate(new Date());
		
		customerList.add(customer);
	}
	
	private boolean isExistId(String id) {
		boolean isExist = false;
		
		for (Customer customer : customerList) {
			if (customer.getId().equals(id)) {
				isExist = true;
				break;
			}
		}
		
		return isExist;
	}
	
	/**
	 * 로그인 여부를 체크하고 해당 고객의 정보를 등록한다.
	 */
	
	public void login() {
		if (loginedUser != null) {
			System.out.println("이미 로그인된 사용자가 있습니다.");
			return;
		}
		
		System.out.print("아이디를 입력하세요: ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String pwd = sc.nextLine();
		
		for (Customer customer : customerList) {
			if (customer.getId().equals(id)) {
				if (customer.getPassword().equals(pwd)) {
					loginedUser = customer;
					System.out.println("로그인 되었습니다.");
				} 
			}
 		}
		
		if (loginedUser == null) {
			System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
	}
	
	/**
	 * 로그아웃하여 현재 고객의 로그인 정보를 삭제한다.
	 */
	
	public void logout() {
		if (loginedUser != null) {
			System.out.println("["+loginedUser.getName()+"]님이 로그아웃 하셨습니다.");
			loginedUser = null;
		}
	}
	
	/**
	 * 현재 등록 중인 책의 리스트를 표시한다.
	 */

	public void displayBooks() {
		/*
		 * 번호	제목							가격
		 * ------------------------------------
		 * 1.	해리포터와 저주받은 아이			18000
		 * 2.	트랜드코리아					25000
		 */
		System.out.printf("%2s %-4s %10s\n", "번호", "제목", "가격");
		System.out.println("----------------------------------------");
		for (Book book : bookList) {
			System.out.printf("%2s %-4s %10s\n", book.getNo(), book.getTitle(), book.getPrice());
		}
	}
	
	/**
	 * 책 번호를 입력하여 현재 로그인 중인 고객에게 책을 대여한다.
	 */
	
	public void rentalBook() {
		if (loginedUser == null) {
			System.out.println("로그인 이후에 이용하세요.");
			return;
		}
		
		Rental rental = new Rental();
		rental.setCustomer(loginedUser);
		
		System.out.print("대여하실 책 번호를 입력하세요: ");
		String no = sc.nextLine();
		for (Book book : bookList) {
			if (no.equals(String.valueOf(book.getNo()))) {
				rental.setBook(book);
				rental.setRentalDate(new Date());
				System.out.println(book.getTitle() + "을(를) 대여하셨습니다.");
			}
		}
		
		rental.setIsBack(false);
		rentalList.add(rental);
	}
	
	/**
	 * 책 번호를 입력하여 대여여부를 반납으로 바꾼다.
	 */
	
	public void backBooks() {
		if (loginedUser == null) {
			System.out.println("로그인 이후에 이용하세요.");
			return;
		}
		
		System.out.print("반납하실 책 번호를 입력하세요: ");
		String no = sc.nextLine();
		
		for (Rental rental : rentalList) {
			if (no.equals(String.valueOf(rental.getBook().getNo()))) {
				rental.setIsBack(true);
				System.out.println(rental.getBook().getTitle() + "을(를) 반납하셨습니다.");
				return;
			}
		}
	}
	
	// 대여중, 반납을 boolean 값을 받아 문자로 리턴하는 메소드
	private String isBookMessage(boolean isBook) {
		String result = null;
		if (isBook == false) {
			result = "대여중";
		} else { 
			result = "반납";
		}
		
		return result;
	}
	
	/**
	 * 현재 로그인 중의 고객이 대여하고 있는 책의 정보를 표시한다.
	 */
	
	public void rentalInfo() {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm");
		int no = 1;
		
		System.out.println("----------------------------------------");
		System.out.println("["+loginedUser.getName()+"]님의 대여목록");
		System.out.printf("%s\t%s\t%s\t%s\n", "번호", "제목", "대여여부", "대여일");
		for (Rental rental : rentalList) {
			calendar.setTime(rental.getRentalDate());
			Date time = calendar.getTime();
			String rentalTime = sdf.format(time);
			System.out.printf("%s%d\t%s\t%s\t%s\n",
							"No.", (no++), rental.getBook().getTitle(), isBookMessage(rental.getIsBack()), rentalTime);
		}
	}
}
