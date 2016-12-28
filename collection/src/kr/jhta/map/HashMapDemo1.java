package kr.jhta.map;

import java.util.HashMap;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("name", "홍길동");
		map.put("phone", "010-1234-5678");
		map.put("email", "hong@naver.com");
		map.put("addr", "서울특별시 종로구 봉익동");
		
		String value1 = map.get("name");
		System.out.println(value1);
		
		String value2 = map.get("email");
		System.out.println(value2);
	}
}
