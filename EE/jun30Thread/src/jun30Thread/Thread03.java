package jun30Thread;

import java.util.ArrayList;

public class Thread03 extends Thread {

	int seq;
	
	public Thread03(int seq) {
		this.seq = seq;
	}
	
	@Override
	public void run() {
		System.out.println(this.seq + " 시작");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(this.seq + " 종료");
	}
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		ArrayList<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			Thread03 t03 = new Thread03(i);
			t03.start();
			list.add(t03);
		}
		
		for (int i = 0; i < list.size(); i++) {
			Thread t = list.get(i);
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main 종료");
	}
}
