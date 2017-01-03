package file;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileMultiReceiverServer {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("서버가 시작되었습니다.");
			
			while (true) {
				Socket socket = server.accept();
				System.out.println("클라이언트와 연결되었습니다.");
				
				FileReceiverThread t = new FileReceiverThread(socket);
				t.start();
			}
		} catch (IOException e) {
			
		}
	}
}
