package object;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BookStoreServer {

	public void startServer() {

		try {
			System.out.println("서버를 시작합니다.");
			ServerSocket server = new ServerSocket(5000);
			
			while (true) {
				System.out.println("클라이언트의 연결을 대기중...");
				Socket socket = server.accept();
				// 연결요청한 클라이언트의 ip주소 조회하기
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("["+ip+"] 클라이언트가 연결되었습니다.");
				
				BookStoreServerThread t = new BookStoreServerThread(socket);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BookStoreServer().startServer();
	}
}
