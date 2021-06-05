package manager;

import java.util.Deque;
import java.util.ArrayDeque;

public class NotifyManager {

	private Deque<String> messageQueue = new ArrayDeque<String>();
	
	private static NotifyManager instance;
	public static NotifyManager getInstance() {
		if (instance == null) {
			instance = new NotifyManager();
		}
		return instance;
	}
	
	private NotifyManager() {
		
	}
	
	public void add(String msg) {
		messageQueue.add(msg);
	}
	
	public void tryPrintMessage() {
		if (messageQueue.isEmpty() == true) {
			return;
		}
		
		System.out.println(messageQueue.pop());
	}
}
