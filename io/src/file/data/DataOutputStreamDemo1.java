package file.data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo1 {
	public static void main(String[] args) throws Exception {
		
		String name = "홍길동";
		int kor = 30;
		int math = 50;
		int eng = 70;
		
		FileOutputStream fos = new FileOutputStream("score2.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF(name);
		dos.writeInt(kor);
		dos.writeInt(math);
		dos.writeInt(eng);
		
		dos.close();
	}
}
