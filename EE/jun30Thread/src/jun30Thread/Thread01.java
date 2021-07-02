package jun30Thread;

public class Thread01 extends Thread {

	@Override
	public void run() {
		System.out.println("쓰레드 시작01");
	}
	
	public static void main(String[] args) {
		Thread01 t01 = new Thread01();
		t01.start();
	}
}
