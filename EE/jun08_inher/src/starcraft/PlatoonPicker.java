package starcraft;

import java.util.ArrayList;

public class PlatoonPicker {
	
	public Unit[] unitArr;
	
	public final int MAX_SIZE = 12;
	
	public PlatoonPicker() {
		unitArr = new Unit[MAX_SIZE];
	}
	
	public Unit[] addMaximum(Unit[] unitArr, String name) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < unitArr.length; i++) {
			if (unitArr[i].name.equals(name)) {
				arrayList.add(i);
			}
		}
		
		for (int i = 0; i < arrayList.size(); i++) {
			int index = arrayList.get(i);
			this.unitArr[i] = unitArr[index];
		}
		
		return this.unitArr;
	}
	
	public void print() {
		for (int i = 0; i < unitArr.length; i++) {
			if (unitArr[i] != null) {
				System.out.println(unitArr[i]);	
			}
		}
	}
}
