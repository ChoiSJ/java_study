package nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Server {
	
	Selector selector;
	ServerSocketChannel serverSocket;
	Charset charset = Charset.defaultCharset();
	ByteBuffer buffer = ByteBuffer.allocate(1024);
	
	// 클라이언트가 보낸 데이터를 소켓채널별로 임시로 담아두는 곳
	// 일반적인 서버환경에서는 절대로 사용하지 않음
	// OP_WRITE를 연습해보기 위해 억지로 끼워넣은 장치다.
	Map<SocketChannel, String> keepData = new HashMap<>();
	
	public void startServer() {
		try {
			selector = Selector.open();						// 셀렉터 생성
			serverSocket = ServerSocketChannel.open();		// 서버소켓 생성
			serverSocket.configureBlocking(false);			// 논블로킹모드로 설정
			serverSocket.bind(new InetSocketAddress(5000));
			System.out.println("서버 시작됨...");
			
			// 셀렉터에 관심키 등록
			serverSocket.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("클라이언트 연결 요청 대기 중...");
			
		} catch (IOException e) {
			stopServer();
			return;
		}
		
		// 관심키 처리하기
		while (true) {
			try {
				// 관심키 갯수 조회하기
				int keyCount = selector.select();
				if (keyCount == 0) {
					continue;
				}
				
				// 관심키 처리 구현
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				
				while (it.hasNext()) {
					SelectionKey key = it.next();
					
					if (key.isAcceptable()) {		// OP_ACCEPT 관심키 처리
						accept(key);
					} else if (key.isReadable()) {	// OP_READ 관심키 처리
						read(key);
					} 
					// 처리된 관심키 삭제
					it.remove();
				}
				
			} catch (IOException e) {
				stopServer();
				break;
			}
		}
	}
	
	public void accept(SelectionKey key) {
		try {
			// 아까 OP_ACCEPT에 관심 있었던 ServerSocketChannel을 가져온다
			serverSocket = (ServerSocketChannel) key.channel();
			SocketChannel socket = serverSocket.accept();
			System.out.println("클라이언트 연결 요청 수락");
			socket.configureBlocking(false);
			
			// 셀렉터에 관심키 등록
			socket.register(selector, SelectionKey.OP_READ);
			
		} catch (IOException e) {
			stopServer();
		}
	}
	
	public void read(SelectionKey key) {
		try {
			buffer.clear();
			
			// 읽기에 관심이 있었던 SocketChannel 꺼내기
			SocketChannel socket = (SocketChannel) key.channel();
			int readByteCount = socket.read(buffer);
			if (readByteCount == -1) {	// 해당소켓으로부터 데이터를 읽지 못한 경우
				socket.close();			// 소켓 닫기
				key.cancel();			// 관심키 등록 취소
				return;
			}
			
			buffer.flip();
			
			/*
			// 억지 코딩
			String data = charset.decode(buffer).toString();
			System.out.println("클라이언트로부터 받은 데이터:" + data);
			keepData.put(socket, data);
			// 클라이언트가 보낸 데이터를 다 읽어서 화면에 표시
			// 이제 이 소켓채널의 관심키를 쓰기로 변경함.
			key.interestOps(SelectionKey.OP_WRITE);
			// 억지 코딩 끝
			*/
			
			// 클라이언트로 데이터 보내기
			//socket.write(buffer);
			//socket.close();
			//key.cancel();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/*
	public void write(SelectionKey key) {
		try {
			SocketChannel socket = (SocketChannel) key.channel();
			String data = keepData.get(socket);
			socket.write(ByteBuffer.wrap(data.getBytes()));
			
			key.interestOps(SelectionKey.OP_READ);
		} catch (IOException e) {
			
		}
	}
	*/
	
	public void stopServer() {
		try {
			if (serverSocket != null && serverSocket.isOpen()) {
				serverSocket.close();
			}
			
			if (selector != null && selector.isOpen()) {
				selector.close();
			}
		} catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		
	}
}
