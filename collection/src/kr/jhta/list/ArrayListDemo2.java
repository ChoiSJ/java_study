package kr.jhta.list;

import java.util.ArrayList;

public class ArrayListDemo2 {
	
	public static void main(String[] args) {
		// 방문자 이름을 저장하는 ArrayList 를 생성하고
		// 방문자 이름을 여러 개 입력하기
		// "김"씨 성을 가진 사람만 새로운 ArrayList에 저장하기
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("강감찬");
		names.add("김유신");
		names.add("홍길동");
		names.add("이순신");
		names.add("김구");
		names.add("홍수김");
		
		ArrayList<String> kimName = new ArrayList<String>();
		
		for (String name : names) {
			String result = name.substring(0, 1);
			if ("김".equals(result)) {
				kimName.add(name);
			}	
		}
		
		System.out.println(kimName);
	}
}
