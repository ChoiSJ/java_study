package kr.jhta.etc;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		
		Stack<String> names = new Stack<String>();
		
		names.push("홍길동");
		names.push("김유신");
		names.push("강감찬");
		
		while (!names.isEmpty()) {
			String name = names.pop();
			System.out.println(name);
		}
	}
}
