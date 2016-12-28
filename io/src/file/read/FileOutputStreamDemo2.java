package file.read;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileOutputStreamDemo2 {
	public static void main(String[] args) throws Exception {
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("유관순");
		
		// "names.txt" 파일에 모든 이름을 기록하기
		
		FileOutputStream fos = new FileOutputStream("names.txt");
		for (String name : names) {
			name = name + System.lineSeparator();
			byte[] bytes = name.getBytes();
			fos.write(bytes);
		}
		
		fos.close();
	}
}
