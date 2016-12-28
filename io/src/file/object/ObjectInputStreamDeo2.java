package file.object;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDeo2 {
	public static void main(String[] args) throws Exception {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.sav"));
		User user = (User) ois.readObject();
		
		System.out.println("이    름:" + user.getName());
		System.out.println("아 이 디:" + user.getId());
		System.out.println("비밀번호:" + user.getPassword());
		
		ois.close();
	}
}
