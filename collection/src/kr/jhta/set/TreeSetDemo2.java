package kr.jhta.set;

import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String[] args) {
		
		TreeSet<Student> students = new TreeSet<Student>();
		
		students.add(new Student("홍길동", 100));
		students.add(new Student("김유신", 70));
		students.add(new Student("강감찬", 60));
		students.add(new Student("이순신", 40));
		students.add(new Student("유관순", 90));
		//students.add(new Student("윤봉길", 100));	// 저장되지 않는다.
		
		Student winner = students.last();
		System.out.println(winner);
		
		System.out.println(students);
	}
	
	public static class Student implements Comparable<Student> {
		private String name;
		private int score;
		
		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		public String getName() {
			return name;
		}
		
		public int getScore() {
			return score;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", score=" + score + "]";
		}

		@Override
		public int compareTo(Student other) {
			int result = score - other.score;
			return result;
		}
	}
}
