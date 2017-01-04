package object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class BookStoreClient {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public void startClient() {
		try {
			socket = new Socket("192.168.10.101", 5000);
			
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			
			login();
			addBook();
			searchBooks();
			exit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void searchBooks() throws IOException, ClassNotFoundException {
		Req req = new Req();
		req.setCommand("SEARCH");
		
		// 서버로 요청 보내기
		out.writeObject(req);
		
		// 서버가 보낸 응답 받기
		Res res = (Res) in.readObject();
		System.out.println("처리결과:" + res.getResult());
		
		HashMap<String, Object> resData = res.getData();
		int records = (Integer) resData.get("records");
		ArrayList<BookVO> books = (ArrayList<BookVO>) resData.get("books");
		
		System.out.println("조회된 책 갯수:" + records);
		for (BookVO vo : books) {
			System.out.println("제목:" + vo.getTitle() + ", 저자:" + vo.getPublisher());
		}
	}
	
	public void addBook() throws IOException, ClassNotFoundException {
		Req req = new Req();
		req.setCommand("ADD");
		
		HashMap<String, Object> reqData = new HashMap<>();
		BookVO vo = new BookVO();
		vo.setTitle("정보처리기사 필기");
		vo.setAuthor("길벗알앤디");
		vo.setPublisher("길벗");
		vo.setPrice(30000);
		reqData.put("book", vo);
		
		//reqData.put("title", "정보처리기사 필기");
		//reqData.put("author", "길벗알앤디");
		//reqData.put("publisher", "길벗");
		//reqData.put("price", 30000);
		
		req.setData(reqData);
		
		// 서버로 전송하기
		out.writeObject(req);
		
		// 처리결과 받기
		Res res = (Res) in.readObject();
		System.out.println("처리결과:" + res.getResult());
		HashMap<String, Object> resData = res.getData();
		String msg = (String) resData.get("msg");
		int no = (Integer) resData.get("no");
		
		System.out.println("메세지:" + msg);
		System.out.println("새책 번호:" + no);
	}
	
	public void login() throws IOException, ClassNotFoundException {
		Req req = new Req();
		req.setCommand("LOGIN");
		
		HashMap<String, Object> data = new HashMap<>();
		data.put("id", "hong");
		data.put("pwd", "zxcv1234");
		req.setData(data);
		
		// Req객체를 서버로 전송하기
		out.writeObject(req);
		
		// 서버가 보내는 데이타를 Res객체로 복원하기
		Res res = (Res) in.readObject();
		System.out.println("처리결과:" + res.getResult());
		System.out.println("메세지:" + res.getData().get("msg"));
	}
	
	public void exit() throws IOException, ClassNotFoundException {
		Req req = new Req();
		req.setCommand("EXIT");
		
		// Req객체를 서버로 전송하기
		out.writeObject(req);
		
		Res res = (Res) in.readObject();
		System.out.println("처리결과:" + res.getResult());
		System.out.println("메세지:" + res.getData().get("msg"));
	}
	
	public static void main(String[] args) {
		new BookStoreClient().startClient();
	}
}
