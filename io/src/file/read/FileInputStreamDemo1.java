package file.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		long start = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("sample.txt");
		
		/*
		int v1 = fis.read();
		int v2 = fis.read();
		int v3 = fis.read();
		
		System.out.println((char)v1);
		System.out.println((char)v2);
		System.out.println((char)v3);
		*/
		
		int value = 0;
		while ((value = fis.read()) != -1) {
			System.out.print((char)value);
		}
		
		fis.close();
		
		long stop = System.currentTimeMillis();
		System.out.println("\n소요시간:" + (stop-start) + "밀리초");
	}
}
