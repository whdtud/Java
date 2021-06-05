package common;

import java.util.ArrayList;

public class PocketMonDB {
	
	private ArrayList<PocketMon> db = new ArrayList<PocketMon>();
	
	public void setData() {
		db.add(new PocketMon("피카츄"));
		db.add(new PocketMon("파이리"));
		db.add(new PocketMon("꼬부기"));
		db.add(new PocketMon("이상해씨"));
		db.add(new PocketMon("구구"));
		db.add(new PocketMon("피죤"));
		db.add(new PocketMon("또가스"));
		db.add(new PocketMon("아보"));
		db.add(new PocketMon("냐옹"));
		db.add(new PocketMon("잉어킹"));
	}
	
	public int size() {
		return db.size();
	}
	
	public PocketMon findByIndex(int index) {
		if (index >= db.size()) {
			return null;
		}
		return db.get(index);
	}
	
	public PocketMon findByName(String name) {
		for (PocketMon pm : db) {
			if (name == pm.name) {
				return pm;
			}
		}
		return null;
	}
}
