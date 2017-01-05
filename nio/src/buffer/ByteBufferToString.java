package buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class ByteBufferToString {
	
	public static void main(String[] args) {
		
		String src = "안녕하세요";
		
		// 문자열 -> ByteBuffer
		
		// 문자열 -> byte배열 -> ByteBuffer
		ByteBuffer buffer1 = ByteBuffer.wrap(src.getBytes());
		
		// 문자열 -> ByteBuffer
		//Charset charset = Charset.defaultCharset();
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer buffer2 = charset.encode(src);
		
		// ByteBuffer -> 문자열
		String clone = charset.decode(buffer1).toString();
		System.out.println(clone);
	}
}
