package file;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiverServer {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(22222);	// 서버 시작
			Socket socket = server.accept();				// 클라이언트 연결
			
			DataInputStream in = new DataInputStream(socket.getInputStream());
			
			// 파일 수신 처리
			// 1. 파일 이름 읽어오기
			String filename = in.readUTF();
			System.out.println("수신받은 파일명:" + filename);
			
			// 2. 전송받은 파일데이터를 읽어서 기록하기
			FileOutputStream fos = new FileOutputStream("c:/project/temp/" + filename);
			int length = 0;
			byte[] buf = new byte[1024];
			while ((length=in.read(buf)) != -1) {
				fos.write(buf, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
