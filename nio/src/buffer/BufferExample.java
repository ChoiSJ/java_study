package buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferExample {
	
	public static void printBufferInfo(Buffer buffer) {
		System.out.printf("position:%d, limit:%d, capacity:%d\n",
							buffer.position(), buffer.limit(), buffer.capacity());
	}
	
	public static void main(String [] args) {
		System.out.println("버퍼 생성");
		ByteBuffer buffer = ByteBuffer.allocate(10);
		printBufferInfo(buffer);
		
		buffer.put((byte)10);
		buffer.put((byte)10);
		buffer.put((byte)10);
		System.out.println("3개 저장");
		printBufferInfo(buffer);
		
		buffer.put((byte)10);
		buffer.put((byte)10);
		buffer.put((byte)10);
		buffer.put((byte)10);
		System.out.println("4개 저장");
		printBufferInfo(buffer);
		
		buffer.flip();
		System.out.println("filp() 실행");
		printBufferInfo(buffer);
		
		buffer.get();
		buffer.get();
		buffer.get();
		System.out.println("3개 읽기");
		printBufferInfo(buffer);
		
		buffer.mark();
		System.out.println("mark() 3번 위치에 마크업");
		
		buffer.get();
		buffer.get();
		System.out.println("2개 읽기");
		printBufferInfo(buffer);
		
		buffer.reset();
		System.out.println("reset() 마크업해놓은 곳으로 이동");
		printBufferInfo(buffer);
		
		buffer.rewind();
		System.out.println("rewind() 실행");
		printBufferInfo(buffer);
		
		buffer.clear();
		System.out.println("clera() 실행");
		printBufferInfo(buffer);
	}
}
