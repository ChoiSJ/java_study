package kr.jhta.set;

import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add(50);
		scores.add(100);
		scores.add(67);
		scores.add(47);
		scores.add(86);
		
		System.out.println(scores);
		// 가장 낮은 값 찾기
		int minValue = scores.first();
		System.out.println(minValue);
		
		// 가장 큰 값 찾기
		int maxValue = scores.last();
		System.out.println(maxValue);
	}
}
