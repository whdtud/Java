import java.util.HashMap;

enum AreaType {
	WORLD,
	BATTLE_ZONE,
	POCKET_MON_CENTER,
}

public class AreaManager {

	private HashMap<AreaType, Area> areaMap = new HashMap<AreaType, Area>();

	private Area currentArea;
	
	private static AreaManager instance;
	public static AreaManager getInstance() {
		if (instance == null) {
			return new AreaManager();
		}
		return instance;
	}
	
	private AreaManager() {
		areaMap.put(AreaType.WORLD, new WorldArea());
		areaMap.put(AreaType.BATTLE_ZONE, new BattleZoneArea());
		areaMap.put(AreaType.POCKET_MON_CENTER, new PocketMonCenterArea());
		
		currentArea = areaMap.get(AreaType.WORLD);
	}
	
	public Area getCurrentArea() {
		return currentArea;
	}
	
	public void changeArea(AreaType type) {
		currentArea = areaMap.get(type);
	}
	
	public void update() {
		currentArea.printName();
		
	}
}
