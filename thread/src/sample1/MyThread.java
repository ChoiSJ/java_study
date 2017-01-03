package sample1;

public class MyThread extends Thread {

	public void run() {
		// 새로운 실행흐름을 사용해서 진행할 작업을 구현하는 곳
		for (int i=1; i<=100; i++) {
			String threadName = getName();
			System.out.println("["+threadName+"] " + i);
		}
	}
}
