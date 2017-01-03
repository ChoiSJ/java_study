package unicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UnicastClient {
	
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.10.101", 5555);
			System.out.println("connected to server...");
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println("서버로 전달할 메세지를 입력하세요.");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				// 키보드 입력 내용 읽어오기
				String text = keyboard.readLine();
				
				if (text.equals("exit")) {
					socket.close();
					break;
				}
				// 서버로 메세지 보내기
				out.println(text);
			
				// 서버가 보낸 응답 메세지 읽기
				String message = in.readLine();
				System.out.println(message);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			try {
				socket.close();
			} catch (IOException ex) {}
		}
	}
}
