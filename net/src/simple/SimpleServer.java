package simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public static void main(String[] args) throws Exception {
		
		// ServerSocker 만들기
		ServerSocket server = new ServerSocket(55555);
		System.out.println("서버가 구동되었습니다.");
		
		// accept() 는 클라이언트의 연결 요청이 올 때까지 대기한다.
		// accept() 는 클라이언트의 연결 요청이 오면 실행된다.
		// accept() 는 클라이언트의 연결 요청이 오면 그 클라이언트와 통신할 Socket 을 생성한다.
		
		while (true) {
			Socket socket = server.accept();
			System.out.println("["+"] 클라이언트와 연결되었습니다");
			
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			
			// 클라이언트가 보낸 메세지 읽기
			String message = br.readLine();
			System.out.println("메세지:" + message);
			
			// 클라이언트로 메세지 보내기
			pw.println(message + "님 환영합니다.");
			
			socket.close();
		}
	}
}
