package file.object;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo2 {
	public static void main(String[] args) throws Exception {
		
		User user = new User();
		user.setName("홍길동");
		user.setId("hong1234");
		user.setPassword("zxcvqwerty");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.sav"));
		oos.writeObject(user);
		
		oos.close();
	}
}
