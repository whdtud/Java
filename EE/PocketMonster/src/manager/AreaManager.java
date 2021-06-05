package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import area.Area;
import area.AreaType;
import area.BattleZoneArea;
import area.PocketMonCenterArea;
import area.PrologueArea;
import area.WorldArea;

public class AreaManager {

	private HashMap<AreaType, Area> areaMap = new HashMap<AreaType, Area>();

	private Area currentArea;
	
	private static AreaManager instance;
	public static AreaManager getInstance() {
		if (instance == null) {
			instance = new AreaManager(); 
		}
		return instance;
	}
	
	private AreaManager() {
		areaMap.put(AreaType.PROLOGUE, new PrologueArea());
		areaMap.put(AreaType.WORLD, new WorldArea());
		areaMap.put(AreaType.BATTLE_ZONE, new BattleZoneArea());
		areaMap.put(AreaType.POCKET_MON_CENTER, new PocketMonCenterArea());
	}
	
	public Area getCurrentArea() {
		return currentArea;
	}

	public void changeArea(int index) {
		AreaType type = AreaType.values()[index]; 
		changeArea(type);
	}
	
	public void changeArea(AreaType type) {
		changeArea(areaMap.get(type));
	}
	
	public void changeArea(Area area) {
		currentArea = area;
		currentArea.onChanged();
	}
	
	public ArrayList<Area> getOtherAreaList() {
		ArrayList<Area> list = new ArrayList<Area>();
		
		for (Map.Entry<AreaType, Area> entry : areaMap.entrySet()) {
			if (entry.getKey() != currentArea.getType()) {
				list.add(entry.getValue());
			}
		}
		return list;
	}
}
