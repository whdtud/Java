package may31;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat03 {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		System.out.println(sdFormat.format(now));
		
		String str = sdFormat.format(now).toString();
		System.out.println(str);
	}

}
