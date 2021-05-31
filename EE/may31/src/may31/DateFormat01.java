package may31;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateFormat01 {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH + 1));
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		System.out.println("출생년도를 입력하세요.");
		Scanner sc = new Scanner(System.in);
//		int input = sc.nextInt();
//		System.out.printf("당신은 %d살 입니다.", cal.get(Calendar.YEAR) - input + 1);
	
		System.out.println(cal.get(Calendar.AM_PM));
		
		System.out.println(cal.getActualMaximum(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		Date date2 = cal.getTime();
		
		sc.close();
	}
}
