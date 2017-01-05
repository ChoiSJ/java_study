package blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Server {
	
	public static void main(String[] args) {
		
		Charset charset = Charset.defaultCharset();
		ServerSocketChannel server = null;
		
		try {
			server = ServerSocketChannel.open();		// 서버소켓채널 생성
			server.configureBlocking(true);				// 블로킹 모드로 동작하도록 설정
			server.bind(new InetSocketAddress(5000));	// 5000포트에 바인딩
			System.out.println("서버가 시작됨...");
			
			while (true) {
				System.out.println("클라이언트의 연결요청 대기 중...");
				SocketChannel channel = server.accept();
				System.out.println("클라이언트 연결요청 수락");
				
				// 버퍼를 생성
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				// 클라이언트가 보낸 메세지 읽어서 버퍼에 담기
				/*
				channel.read(buffer);
				buffer.flip();
				
				channel.write(buffer);
				buffer.clear();
				*/
				
				int len = channel.read(buffer);
				String data = "";
				if (len > 0) {
					buffer.flip();
					data = charset.decode(buffer).toString();
					System.out.println("클라이언트가 보낸 메세지:" + data);
				}
				
				buffer = ByteBuffer.wrap((data + "님 환영합니다.").getBytes());
				channel.write(buffer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
