package file.character;

import java.io.FileWriter;

public class FileWriterDemo1 {
	public static void main(String[] args) throws Exception {
		
		FileWriter writer = new FileWriter("song.txt");
		
		writer.write("학교종이 땡땡땡 어서 모이자 선생님이 우리를 기다린다.");
		writer.flush();	// FileWriter 의 내부버퍼에 보관된 데이터를 진짜로 출력하게 한다.
		writer.close();
	}
}
