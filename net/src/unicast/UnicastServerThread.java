package unicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UnicastServerThread extends Thread {
	
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	// 스레드 객체 생성할 때, 이 스레드가 사용할 소켓을 전달받는다.
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		while (true) {
			try {
				// 클라이언트가 보낸 메세지 수신하기
				String message = in.readLine();
				System.out.println("메세지:" + message);
				
				// 클라이언트로 응답 메세지 보내기
				out.println("서버응답:" + message);
				
			} catch (IOException e) {
				e.printStackTrace();
				try {
					socket.close();
				} catch (IOException e2) {}
				break;
			}
		}
	}
}
