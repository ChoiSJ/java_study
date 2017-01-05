package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteExample {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("c:", "project", "temp", "file.txt");
		FileChannel channel = FileChannel.open(path,
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "학교종이 땡땡땡 어서 모이자";
		ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
		
		// 버퍼에서 읽어서 출력(기록)하기
		int len = channel.write(buffer);
		System.out.println("["+len+"] byte 기록함");
		channel.close();
	}
}
