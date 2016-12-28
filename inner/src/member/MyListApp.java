package member;

import java.util.Iterator;

public class MyListApp {
	public static void main(String[] args) {
		
		MyList list = new MyList();
		Iterator<String> it = list.iterator();
		
		while (it.hasNext()) {
			String n = it.next();
			System.out.println(n);
		}
	}
}
