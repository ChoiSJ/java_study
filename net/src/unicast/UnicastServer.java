package unicast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(5555);
			System.out.println("Server started...");
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		while (true) {
			try {
				System.out.println("Waiting for connection...");
				Socket socket = server.accept();
				
				UnicastServerThread t = new UnicastServerThread(socket);
				t.start();
				
			} catch (IOException e) {
				System.err.println(e.getMessage());
				break;
			}
		}
		
		try {
			server.close();
		} catch (IOException e) {}
	}
}
