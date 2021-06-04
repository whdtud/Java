
public class WorldArea extends Area {

	public WorldArea() {
		type = AreaType.WORLD;
		name = "월드맵";
	}
	
	@Override
	public void printAction() {
		System.out.println("입장할 지역을 선택해주세요.");
		System.out.println("[1] 전투 지역, [2] 포켓몬 센터");	
		
		int input = InputManager.getInstance().getScanner().nextInt();
		switch (input) {
		case 1:
			AreaManager.getInstance().changeArea(AreaType.BATTLE_ZONE);
			break;
		case 2:
			AreaManager.getInstance().changeArea(AreaType.POCKET_MON_CENTER);
			break;
		}
	}
}
