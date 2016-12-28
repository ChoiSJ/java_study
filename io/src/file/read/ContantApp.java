package file.read;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ContantApp {
	public static void main(String[] args) throws Exception {
		// 1. contacts.txt 의 내용을 읽어서 화면에 표시하기
		// 2. contacts.txt 의 내용을 한 사람씩 구분해서 화면에 표시하기
		// 3. ArrayList<Contant>를 생성해서 모든 사람의 정보를 저장하기
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		FileInputStream fis = new FileInputStream("contacts.txt");
		int count = 0;
		byte[] buf = new byte[1024];
		StringBuilder sb = new StringBuilder();
		
		while ((count=fis.read(buf)) != -1) {
			String text = new String(buf, 0 , count);
			sb.append(text);
		}
		
		String data = sb.toString();
		String[] cts = data.split(":");
		
		/*
		for (String contact : cts) {
			System.out.println(contact);
		}
		*/
		
		for (String ct : cts) {
			String[] arr = ct.split(",");
			Contact contact = new Contact();
			contact.setName(arr[0]);
			contact.setTel(arr[1]);
			contact.setEmail(arr[2]);
			contacts.add(contact);
		}
		
		for (Contact c : contacts) {
			System.out.printf("%s, %s, %s\n", c.getName(), c.getTel(), c.getEmail());
		}

		fis.close();
	}
}
