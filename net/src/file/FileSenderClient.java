package file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileSenderClient {
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.10.101", 8888);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			String filename = "SceneBuilder-8.3.0.exe";
			// 파일명 보내기
			out.writeUTF(filename);
			
			File file = new File("C:/Users/JHTA/Downloads/SceneBuilder-8.3.0.exe");
			long size = file.length();
			
			// 파일 사이즈 보내기
			out.writeLong(size);
			
			FileInputStream fis = new FileInputStream(file);
			
			// 파일 데이터 보내기
			int length = 0;
			byte[] buf = new byte[1024];
			while ((length=fis.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
			
			fis.close();
			socket.close();
			
			System.out.println("전송이 완료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
