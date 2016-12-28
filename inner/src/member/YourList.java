package member;

import java.util.Iterator;

public class YourList {
	private String[] names = {"홍길동", "김유신", "강감찬", "이순신"};
	
	public Iterator<String> iterator() {
		class YourListIterator implements Iterator<String> {
			private int index = 0;
			public boolean hasNext() {
				if (index < names.length) {
					return true;
				}
				
				return false;
			}
			
			public String next() {
				String name = names[index];
				index++;
				return name;
			}
		}
		
		YourListIterator itr = new YourListIterator();
		return itr;
	}
}
