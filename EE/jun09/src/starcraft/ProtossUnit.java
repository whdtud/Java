package starcraft;

public abstract class ProtossUnit extends SCUnit implements IShield {

	protected int shield;
	
	@Override
	public int getShield() {
		return shield;
	}
	
	@Override
	public void setShield(int value) {
		shield = value;
	}
	
	@Override
	public void recovery() {
		shield++;
	}
}
