package area;

import java.util.ArrayList;

import common.Player;
import common.PocketMon;
import manager.AreaManager;
import manager.InputManager;
import manager.PocketMonManager;

public class PrologueArea extends Area {

	private ArrayList<PocketMon> pocketMonList = new ArrayList<PocketMon>();
	
	public PrologueArea() {
		name = "오박사 연구소";
		
		pocketMonList.add(PocketMonManager.getInstance().get("피카츄"));
		pocketMonList.add(PocketMonManager.getInstance().get("파이리"));
		pocketMonList.add(PocketMonManager.getInstance().get("꼬부기"));
		pocketMonList.add(PocketMonManager.getInstance().get("이상해씨"));
	}
	
	@Override
	public AreaType getType() {
		return AreaType.PROLOGUE;
	}

	@Override
	protected void printAction() {
		Player player = Player.getInstance();
		if (player.getName() != null) {
			System.out.println("뭐하러 다시 돌아왔나? 혼자 있고 싶으니 당장 나가게.");
			System.out.println("철컥-");
			AreaManager.getInstance().changeArea(AreaType.WORLD);
		}
		
		System.out.println("??? : 자네 이름이 뭔가?");
		
		while (true) {
			System.out.print("당신의 이름을 입력해주세요 : ");
			
			String name = InputManager.getInstance().getScanner().nextLine();
			player.setName(name);
			
			if (player.getName() == null || player.getName().isEmpty()) {
				System.out.println("공백은 불가능합니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		
		System.out.println();
		System.out.println("오박사 : 반갑네! 난 오박사라고 하네.");
		System.out.println("오박사 : 함께 할 포켓몬을 선택하게나.");
		
		int index = -1;
		while (true) {
			for (int i = 0; i < pocketMonList.size(); i++) {
				System.out.printf("[%d] %s ", i + 1, pocketMonList.get(i).name);
			}
			System.out.println();
			
			index = InputManager.getInstance().getScanner().nextInt() - 1;
			if (index < 0 || index >= pocketMonList.size()) {
				System.out.println("입력 오류입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		
		PocketMon pm = pocketMonList.get(index);
		player.addPocketMon(pm);
		
		System.out.printf("%s(을)를 선택했구나. 그럼 이만 나가보거라.\n", pm.name);
		System.out.println("철컥-");
		System.out.println();
		
		AreaManager.getInstance().changeArea(AreaType.WORLD);
	}
}
