package starcraft;

public class ProtossUnit extends Unit {
	int shield;
	
	public void attack() {
		System.out.println("공격");
	}
	
	public void shieldCharge() {
		System.out.println("보호막 회복");
	}
}
