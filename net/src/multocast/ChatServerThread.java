package multocast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerThread extends Thread {
	
	private Socket socket;
	private ArrayList<ChatServerThread> list;
	private BufferedReader in;
	private PrintWriter out;
	
	public ChatServerThread(Socket socket, ArrayList<ChatServerThread> list) {
		this.socket = socket;
		this.list = list;
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while (true) {
				String message = in.readLine();
				System.out.println(message);

			
				// 모든 클라이언트에게 메세지 보내기
				broadcast(message);
				
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			list.remove(this);
		}
	}
	
	// 이 스레드와 연결된 클라이언트에게 메세지 보내기
	public void sendMessage(String message) {
			out.println(message);
	}
	
	// 모든 클라이언트에게 메세지 보내기
	public void broadcast(String message) {
		for (ChatServerThread t : list) {
			t.sendMessage(message);
		}
	}
}
