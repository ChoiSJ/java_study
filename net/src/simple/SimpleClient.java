package simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
	
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("192.168.10.101", 55555);
		
		// 서버로 메세지를 보내는 스트림 얻기
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		// 서버가 보낸 메세지를 읽는 스트림 얻기
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// 서버로 메세지 보내기
		pw.println("최승준");
		
		// 서버가 보낸 메시지 읽기
		String message = br.readLine();
		System.out.println("메세지:" + message);
		
		socket.close();
	}
}
