package jun02;

class Cat {
	
	public void eat() {
		System.out.println("taste good!");
	}
	
	public void grooming() {
		System.out.println("grooroong!");
	}
}

public class OOP04 {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		cat.grooming();
	}

}
