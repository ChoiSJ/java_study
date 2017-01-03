package sample1;

public class MyThreadApp {
	
	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		t1.setName("1번 스레드");
		
		MyThread t2 = new MyThread();
		t2.setName("2번 스레드");
		
		MyThread t3 = new MyThread();
		t3.setName("3번 스레드");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
