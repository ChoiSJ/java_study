package kr.jhta.etc;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		
		Queue<String> names = new LinkedList<String>();
		
		names.offer("김유신");
		names.offer("강감찬");
		names.offer("홍길동");
		
		while (!names.isEmpty()) {
			String name = names.poll();
			System.out.println(name);
		}
	}
}
