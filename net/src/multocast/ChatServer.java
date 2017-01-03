package multocast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	
	ArrayList<ChatServerThread> list = new ArrayList<ChatServerThread>();
	
	public void startServer() {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(5555);
			System.out.println("채팅 서버가 시작되었습니다.");
			
			while (true) {
				System.out.println("클라이언트의 요청을 기다리는 중...");
				Socket socket = server.accept();
				
				ChatServerThread t = new ChatServerThread(socket, list);
				list.add(t);
				
				t.start();
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		ChatServer chatServer = new ChatServer();
		
		chatServer.startServer();
	}
}
