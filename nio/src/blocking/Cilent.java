package blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Cilent {
	
	public static void main(String[] args) {
		
		SocketChannel channel = null;
		Charset charset = Charset.defaultCharset();
		
		try {
			channel = SocketChannel.open();		// 소켓채널 생성 
			channel.configureBlocking(true);	// 블로킹모드로 설정
			
			// 서버로 연결요청 보내기
			channel.connect(new InetSocketAddress("192.168.10.101", 5000));
			System.out.println("서버와 연결 성공...");
			
			// 서버로 메세지 보내기
			String message = "반갑습니다.";
			ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
			channel.write(buffer);
			
			// 서버가 보낸 메세지 받기
			buffer = ByteBuffer.allocate(1024);
			int readByteCount = channel.read(buffer);
			if (readByteCount < 0) {
				buffer.flip();
				message = charset.decode(buffer).toString();
				System.out.println("서버가 보낸 메세지:" + message);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
