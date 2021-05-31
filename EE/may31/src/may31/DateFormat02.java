package may31;

import java.util.Calendar;
import java.util.Date;

public class DateFormat02 {

	public static void main(String[] args) {
	
		// 2021년 5월 31일 월요일 오전 10시 30분 59초입니다.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println();
		
		Date date = cal.getTime();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String ampm = cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		String week = "";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			week = "일요일";
			break;
		case 2:
			week = "월요일";
			break;
		case 3:
			week = "화요일";
			break;
		case 4:
			week = "수요일";
			break;
		case 5:
			week = "목요일";
			break;
		case 6:
			week = "금요일";
			break;
		case 7:
			week = "토요일";
			break;
		}
		
		System.out.printf("%d년 %d월 %d일 %s %s %d시 %d분 %d초입니다.", year, month, day, week, ampm, hour, minute, second);
	}
}
