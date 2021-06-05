package manager;

import common.PocketMon;
import common.PocketMonDB;

public class PocketMonManager {
	
	private PocketMonDB db;
	
	private static PocketMonManager instance;
	public static PocketMonManager getInstance() {
		if (instance == null) {
			instance = new PocketMonManager();
		}
		return instance;
	}
	
	private PocketMonManager() {
		db = new PocketMonDB();
		db.setData();
	}
	
	public PocketMon get(String name) {
		PocketMon pocketMon = null;
		try {
			pocketMon = db.findByName(name).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return pocketMon;
	}
	
	public PocketMon get(int index) {
		PocketMon pocketMon = null;
		try {
			pocketMon = db.findByIndex(index).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return pocketMon;
	}
	
	public PocketMon getRandom() {
		int random = (int)(Math.random() * db.size());

		return get(random);
	}
}
