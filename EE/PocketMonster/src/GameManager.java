public class GameManager {

	private boolean isPlaying;
	
	public void init() {
	}
	
	public void release() {
		InputManager.getInstance().release();
	}
	
	public void updateLoop() {
		while (isPlaying) {
			AreaManager.getInstance().update();
		}
	}
}
