package kr.jhta.list;

import java.util.ArrayList;

public class ArrayListDemo4 {
	
	public static void displayNameByFamilyName(ArrayList<String> list, String familyName) {
		for (String name : list) {
			if (familyName.equals(name.substring(0, familyName.length()))) {
				System.out.println(name);
			}
		}
	}
	
	// 정적메소드 정의하기
	// ArrayList 와 "성씨"를 전달받아서 그 "성씨"에 해당하는 이름을 ArrayList 에 담아서 반환하는 메소드
	
	public static ArrayList<String> getNameByFamilyName(ArrayList<String> list, String familyName) {
		ArrayList<String> result = new ArrayList<String>();
		
		for (String name : list) {
			if (familyName.equals(name.substring(0, familyName.length()))) {
				result.add(name);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		// 정적메소드 정의하기
		// ArrayList 와 "성씨"를 전달받아서 그 "성씨"에 해당하는 이름을 출력하는 메소드
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("강감찬");
		names.add("김유신");
		names.add("홍길동");
		names.add("이순신");
		names.add("김구");
		names.add("홍수김");
		names.add("독고탁");
		
		displayNameByFamilyName(names, "독고");
		ArrayList<String> resultName = new ArrayList<String>(getNameByFamilyName(names, "독고"));
		
		System.out.println(resultName);
	}
}
