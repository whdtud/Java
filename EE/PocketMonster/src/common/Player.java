package common;

import java.util.ArrayList;

public class Player {

	private String name;
	
	public ArrayList<PocketMon> pocketMonList = new ArrayList<PocketMon>();
	
	private final int MAIN_SLOT_INDEX = 0;

	private static Player instance;
	public static Player getInstance() {
		if (instance == null) {
			instance = new Player();
		}
		return instance;
	}
	
	private Player() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			return;
		}
		
		this.name = name;
	}
	
	public PocketMon getMainPocketMon() {
		return pocketMonList.get(MAIN_SLOT_INDEX);
	}
	
	public void addPocketMon(PocketMon pocketMon) {
		pocketMonList.add(pocketMon);
	}
}
