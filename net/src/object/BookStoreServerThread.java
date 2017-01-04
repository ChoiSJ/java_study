package object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BookStoreServerThread extends Thread {

	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public BookStoreServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			
			while (true) {
				
				// 클라이언트가 전송한 데이타를 읽어서 Req객체로 복원하기
				Req req = (Req) in.readObject();
				
				String command = req.getCommand();
				System.out.println("클라이언트 요청 ["+command+"]");
				
				if ("LOGIN".equals(command)) {
					processLogin(req);
					
				} else if ("LOGOUT".equals(command)) {
					processLogout(req);
					
				} else if ("SEARCH".equals(command)) {
					processSearch(req);
					
				} else if ("ADD".equals(command)) {
					processAddBook(req);
					
				} else if ("DEL".equals(command)) {
					
					
				} else if ("EXIT".equals(command)){
					processExit(req);
					break;
				}
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	// 클라이언트의 로그인 요청 처리
	private void processLogin(Req req) throws IOException {
		HashMap<String, Object> data = req.getData();
		
		String idValue = (String) data.get("id");
		String pwdValue = (String) data.get("pwd");
		System.out.println("아이디["+idValue+"] 비밀번호["+pwdValue+"]");
		
		// db에서 조회한 정보 
		String dbId = "hong";
		String dbPwd = "zxcv1234";
		
		Res res = new Res();
		HashMap<String, Object> resData = new HashMap<>();
		
		if (dbId.equals(idValue) && dbPwd.equals(pwdValue)) {
			res.setResult("성공");
			resData.put("msg", "로그인이 완료되었습니다.");
			
		} else {
			res.setResult("실패");
			resData.put("msg", "아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		res.setData(resData);
		
		// 클라이언트로 Res객체를 전송하기
		out.writeObject(res);
		
	}
	
	public void processAddBook(Req req) throws IOException {
		HashMap<String, Object> reqData = req.getData();
		BookVO vo = (BookVO) req.getData().get("book");
		
		//String title = (String) reqData.get("title");
		//String author = (String) reqData.get("author");
		//String publisher = (String) reqData.get("publisher");
		//int price = (Integer) reqData.get("price");
		
		System.out.printf("제목:%s, 저자:%s, 출판사:%s, 가격:%d\n",
							vo.getTitle(), vo.getAuthor(), vo.getPublisher(), vo.getPrice());
		
		Res res = new Res();
		res.setResult("저장완료");
		
		Random random = new Random();
		HashMap<String, Object> resData = new HashMap<>();
		resData.put("msg", "책 정보가 저장되었습니다.");
		resData.put("no", random.nextInt(1000));	// 책 정보가 저장될 때 부여받은 시퀸스번호
		res.setData(resData);
		
		out.writeObject(res);
	}
	
	// 클라이언트의 로그아웃 요청 처리
	private void processLogout(Req req) throws IOException {
		
	}

	// 클라이언트의 책정보 조회요청 처리
	private void processSearch(Req req) throws IOException {
		Res res = new Res();
		HashMap<String, Object> resData = new HashMap<>();
		
		res.setResult("처리완료");
		
		ArrayList<BookVO> bookList = new ArrayList<>();
		bookList.add(new BookVO("자바", "신용권", "한빛", 35000));
		bookList.add(new BookVO("c++", "윤인성", "한빛", 30000));
		
		resData.put("records", bookList.size());
		resData.put("books", bookList);
	}
	
	private void processExit(Req req) throws IOException {
		Res res = new Res();
		HashMap<String, Object> resData = new HashMap<>();
		
		res.setResult("종료");
		resData.put("msg", "연결을 해제합니다.");
		res.setData(resData);

		// Res객체를 클라이언트로 보내기
		out.writeObject(res);
	}
}
