package file.second;

import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) throws Exception {
		
		PrintStream ps = new PrintStream("data.txt");
		
		ps.println("홍길동,10,20,30");
		ps.println("김유신,30,60,40");
		ps.println("강감찬,40,70,70");
		ps.println("이순신,20,80,100");
		
		ps.close();
	}
}
