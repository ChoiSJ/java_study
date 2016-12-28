package file.character;

import java.io.FileReader;

public class FileReaderDemo1 {
	public static void main(String[] args) throws Exception {
		
		FileReader reader = new FileReader("song.txt");
		
		int count = 0;
		// 글자 1024개를 담을 수 있는 버퍼생성
		char[] buf = new char[1024];
		while ((count=reader.read(buf)) != -1) {
			String str = new String(buf, 0 , count);
			System.out.println(str);
		}
		
		reader.close();
	}
}
