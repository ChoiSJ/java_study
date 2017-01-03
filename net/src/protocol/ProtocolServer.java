package protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket listener = new ServerSocket(9999);
			
			while (true) {
				Socket socket = listener.accept();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				
				String requestMsg = in.readLine();
				String[] messages = requestMsg.split(":");
				
				if ("C".equals(messages[0])) {
					System.out.println("["+messages[1]+"] 방 만들기...");
					out.println("["+messages[1]+"] 방이 만들어졌습니다. ");
				} else if ("I".equals(messages[0])) {
					System.out.println("["+messages[1]+"] 사용자 초대");
					out.println("["+messages[1]+"]를 ["+messages[2]+"]로 초대했습니다.");
				} else if ("M.".equals(messages[0])) {
					System.out.println("["+messages[1]+"]에게 메세지 전송...");
					out.println("["+messages[1]+"]에게 ["+messages[2]+"]를 보냈습니다.");
				} else {
					System.out.println("유효하지 않은 요청...");
					out.println("유효하지 않은 요청입니다.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
