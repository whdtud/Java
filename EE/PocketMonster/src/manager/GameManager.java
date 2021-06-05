package manager;

import area.AreaType;

public class GameManager {

	public void init() {
	}
	
	public void release() {
		InputManager.getInstance().release();
	}
	
	public void start() {
		AreaManager.getInstance().changeArea(AreaType.PROLOGUE);
	}
}
