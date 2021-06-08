package starcraft;

public class Zealot extends ProtossUnit {

	public Zealot() {
		name = "질럿";
	}
	
	public Zealot(String name, int strength, int shield) {
		this.name = name;
		this.shield = shield;
		this.hp = strength;
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
