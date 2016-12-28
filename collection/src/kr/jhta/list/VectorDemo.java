package kr.jhta.list;

import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		
		Vector<String> names = new Vector<String>();
		
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		
		for (String name : names) {
			System.out.println(name);
		}
	}
}
