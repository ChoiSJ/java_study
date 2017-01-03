package sample2;

import java.util.ArrayList;
import java.util.Vector;

public class MyRunnable extends Thread {
	
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public void run() {
		putNumber();
	}
	
	public synchronized void putNumber() {
		for (int i=1; i<=100; i++) {
			numbers.add(i);
		}
		
		System.out.println("사이즈:" + numbers.size());
	}
}
