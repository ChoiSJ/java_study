package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReadExample {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("c:", "project", "temp", "file.txt");
		Charset charset = Charset.defaultCharset();
		
		FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		channel.read(byteBuffer);
		byteBuffer.flip();	// position을 0으로 만듦
		String data = charset.decode(byteBuffer).toString();
		
		System.out.println(data);
		
		channel.close();
	}
}
