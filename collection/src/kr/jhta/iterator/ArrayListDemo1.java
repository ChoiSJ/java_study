package kr.jhta.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(new Contact("홍길동", "010-1234-5678"));
		contacts.add(new Contact("김유신", "010-7894-5612"));
		contacts.add(new Contact("강감찬", "010-4569-9632"));
		
		Iterator<Contact> it = contacts.iterator();
		while (it.hasNext()) {
			Contact contact = it.next();
			System.out.println(contact.getName() + ", " + contact.getPhone());
		}
	}
	
	public static class Contact {
		
		private String name;
		private String phone;
		
		public Contact() {}
		
		public Contact(String name, String phone) {
			super();
			this.name = name;
			this.phone = phone;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
	}
}
