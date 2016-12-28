package kr.jhta.map;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo3 {
	
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
		
		// Map객체가 가지고 있는 모든 key를 반환하는 메소드
		// Set<k> keySet<> : key객체를 Set에 담아서 반환한다.(key는 중복된 값이 없다.)
		
		Set<String> keys = map.keySet();
		
		for (String key : keys) {
			String value = map.get(key);
			System.out.println("["+key+"] " + value);
		}
	}
}
