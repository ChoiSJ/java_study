package file.second;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrinterWriterDemo {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// new PrintWriter(Writer w, boolean autoFlush)
		// autoFlush 를 true 설정하면 자동으로 버퍼에 저장된 값을 스트림을 사용해서 출력한다.
		// autoFlush 를 true 설정하지 않으면 flush 를 실행해서 버퍼에 저장된 값을 강제로 스트림을 사용해서 출력할 수 없다.
		PrintWriter writer = new PrintWriter(new FileWriter("address.txt"), true);
		
		for (int i=1; i<=3; i++) {
			System.out.println("배송주소를 입력하세요:");
			String text = sc.nextLine();
			
			writer.println(text);
			//writer.flush();
		}
		
		writer.close();
		sc.close();
	}
}
