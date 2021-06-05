package area;

public abstract class Area {

	protected String name;
	
	public abstract AreaType getType();
	
	protected void printName() {
		System.out.printf("[==%s==]\n", name);
	}
	
	protected abstract void printAction();
	
	public void onChanged() {
		printName();
		printAction();
	}
}
