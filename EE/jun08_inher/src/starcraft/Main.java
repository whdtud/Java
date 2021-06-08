package starcraft;

public class Main {
	
	public static void main(String[] args) {
		
		Unit[] unitArr = createUnitByRandom();
		
		PlatoonPicker picker = new PlatoonPicker();
		
		Unit[] resultArr = picker.addMaximum(unitArr, "저글링");

		System.out.println("찾은 개수 : " + resultArr.length);
		
		for (int i = 0; i < resultArr.length; i++) {
			if (resultArr[i] != null) {
				System.out.println(resultArr[i]);				
			}
		}
		
		//picker.print();
	}
	
	public static Unit[] createUnitByRandom() {
		
		Unit[] unitArr = new Unit[30];
		
		for (int i = 0; i < unitArr.length; i++) {
			int random = (int)(Math.random() * 3);
			
			switch (random) {
			case 0:
				unitArr[i] = new Zealot();
				break;
			case 1:
				unitArr[i] = new Marine();
				break;
			case 2:
				unitArr[i] = new Zergling();
				break;
			}
		}
		return unitArr;
	}
}
