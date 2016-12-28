package sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----신규 책 정보 입력-----");
		System.out.println("번호를 입력하세요:");
		int no = Integer.parseInt(sc.nextLine());
		
		System.out.println("제목을 입력하세요:");
		String title = sc.nextLine();
		
		System.out.println("저자를 입력하세요:");
		String author = sc.nextLine();
		
		System.out.println("출판사를 입력하세요:");
		String publisher = sc.nextLine();
		
		System.out.println("가격을 입력하세요:");
		int price = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		// 1. 드라이버 로드(등록) -> 드라이버 레지스트리에 오라클 jdbc 드라이버 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//OracleDriver driver = new OralceDriver();
		
		// 2. 등록된 jdbc 드라이버를 사용해서 데이터베이스와 연결하기
		// -> 연결이 성공하면 데이터베이스와 연결을 유지하고 있는 Connection 객체를 얻을 수 있다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, username, password);
		
		// 3. SQL 전송을 담당하는 Statement 객체 얻어오기
		Statement stmt = con.createStatement();
		
		// 4. SQL 전송 및 실행
		String sql = "insert into tb_book values("+no+", '"+title+"', '"+author+"', '"+publisher+"', "+price+", sysdate)";
		int result = stmt.executeUpdate(sql);
		System.out.println(result + "개의 행이 추가되었습니다.");
		
		// 5. 자원해제: 획득한 순서의 역순으로 자원을 해제한다.
		stmt.close();
		con.close();
	}
}
