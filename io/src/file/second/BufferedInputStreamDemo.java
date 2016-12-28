package file.second;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
	public static void main(String[] args) throws Exception {
		
		String resource = "C:\\Users\\JHTA\\Downloads\\Git-2.10.2-64-bit.exe";
		/*
		long begin1 = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(resource);
		
		while (fis.read() != -1) {}
		fis.close();
		long end1 = System.currentTimeMillis();
		
		System.out.println("소요시간:" + (end1-begin1) + "밀리초");
		*/
		
		long begin2 = System.currentTimeMillis();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resource));
		
		while (bis.read() != -1) {}
		bis.close();
		long end2 = System.currentTimeMillis();
		System.out.println("소요시간:" + (end2-begin2) + "밀리초");
	}
}
