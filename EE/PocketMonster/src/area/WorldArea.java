package area;

import java.util.ArrayList;

import manager.AreaManager;
import manager.InputManager;

public class WorldArea extends Area {

	public WorldArea() {
		name = "월드맵";
	}
	
	@Override
	public AreaType getType() {
		return AreaType.WORLD;
	}

	@Override
	public void printAction() {
		ArrayList<Area> areaList = AreaManager.getInstance().getOtherAreaList();
		
		System.out.println("입장할 지역을 선택해주세요.");
		for (int i = 0; i < areaList.size(); i++) {
			System.out.printf("[%d] %s ", i + 1, areaList.get(i).name);
		}
		System.out.println();
		
		int input = InputManager.getInstance().getScanner().nextInt();
		int areaIndex = input - 1;
		AreaManager.getInstance().changeArea(areaList.get(areaIndex));
	}
}
