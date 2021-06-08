package starcraft;

public class Protoss extends StarCraft {
	String clan;
	int shield;
	
	public void attack() {
		System.out.println("공격");
	}
	
	public void shieldCharge() {
		System.out.println("보호막 회복");
	}
}
