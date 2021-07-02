package jun30Thread;

public class Thread02 extends Thread {

	int seq;
	
	public Thread02(int seq) {
		this.seq = seq;
	}
	
	@Override
	public void run() {
		System.out.println(this.seq + "쓰레드 시작02");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(this.seq + "쓰레드 끝");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread02 t02 = new Thread02(i);
			t02.start();	
		}
		System.out.println("메인 끝");
	}
}
