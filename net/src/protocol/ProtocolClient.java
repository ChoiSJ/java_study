package protocol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ProtocolClient {
	
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("192.168.10.101", 9999);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//String sendMsg = "C:동네친구";
		String sendMsg = "I:홍길동:동네친구";
		//String sendMsg = "M:자바:오늘 저녁 뭐 하냐?";
		
		out.println(sendMsg);
		
		String receiveMsg = in.readLine();
		System.out.println("응답메시지:" + receiveMsg);
	}
}
