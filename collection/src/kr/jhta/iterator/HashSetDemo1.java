package kr.jhta.iterator;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {
	
	public static void main(String[] args) {
		
		HashSet<String> names = new HashSet<String>();
		
		names.add("홍길동");
		names.add("김구");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("유관순");
		
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
	}
}
