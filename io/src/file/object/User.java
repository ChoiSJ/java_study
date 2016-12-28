package file.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 4765379652784953343L;
	private String name;
	private String id;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * 직렬화할 때 실행된다.
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("직렬화 작업 수행 중...");
		String firstChar = name.substring(0, 1);
		out.writeUTF(firstChar + "**");
		
		int halfLength = id.length()/2;
		String halfId = id.substring(0, halfLength);
		for  (int i=0; i<id.length()-halfLength; i++) {
			halfId += "*";
		}
		out.writeUTF(halfId);
	}
	
	/*
	 * 역직렬화할 때 실행된다.
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("역직렬화 작업 수행 중...");
		name = in.readUTF();
		id = in.readUTF();
	}
}
