enum SystemMessageType {
	LOBBY_SELECT_ACTION,
	BATTLE_SELECT_ACTION,
}

public class SystemMessage {
	

	private static SystemMessage instance;
	public static SystemMessage getInstance() {
		if (instance == null) {
			return new SystemMessage();
		}
		return instance;
	}
	
	private SystemMessage() {
	}
	
	public void print(SystemMessageType type) {
		switch (type) {
		case LOBBY_SELECT_ACTION:
			
			break;
		case BATTLE_SELECT_ACTION:
			break;
		}
	}
}
