package may31;

import java.util.Date;

public class DateFormat05 {

	public static void main(String[] args) {

		long millis = System.currentTimeMillis();
		System.out.println(millis);

		Date date = new Date();
		System.out.println(date);
		
		Date xMas = new Date(121, 11, 25);
		System.out.println(xMas);
		System.out.println(xMas.getDay());
		
		long howLong = xMas.getTime() - date.getTime();
		System.out.println(howLong);

		long result = howLong / (1000 * 60 * 60 * 24);
		
		System.out.println(result);
	}
}
