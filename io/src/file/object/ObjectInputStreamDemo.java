package file.object;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("account.sav");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		/*
		 * FileInputStream 을 이용해서 읽어온 직렬화된 정보를
		 * readObject() 는 객체로 복원한다.
		 */
		
		Account account = (Account) ois.readObject();
		System.out.println("예 금 주:" + account.getName());
		System.out.println("계좌번호:" + account.getAccNumber());
		System.out.println("잔    액:" + account.getBalance());
		
		ois.close();
	}
}
