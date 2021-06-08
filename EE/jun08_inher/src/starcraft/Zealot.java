package starcraft;

public class Zealot extends ProtossUnit {

	public Zealot(String name, int strength, int shield) {
		this.name = name;
		this.shield = shield;
		this.strength = strength;
	}
	
	@Override
	public void attack() {
		System.out.println("질럿이 공격합니다.");
	}
	
	@Override
	public void shieldCharge() {
		this.shield += 2;
	}
}
