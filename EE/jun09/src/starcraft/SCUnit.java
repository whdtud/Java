package starcraft;

public abstract class SCUnit {
	
	public String name;
	public int hp;
	public int maxHp;
	public int power;
	public int defense;
	
	public void attack(SCUnit target) {
		System.out.printf("ATTACK %d || %s -> %s\n", power, name, target.name);

		target.onDamaged(power);
	}
	
	private void onDamaged(int power) {
		hp -= power;
		
		System.out.printf("DAMAGED %d || %s HP(%d/%d)\n", power, name, hp , maxHp);
	}
}
