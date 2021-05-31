package may31;

import java.text.MessageFormat;

public class TextFormat01 {

	public static void main(String[] args) {
		String name = "HongGilDong";
		String id = "hong5000";
		String tel = "010-5569-8102";
		
		System.out.printf("name : %s id : %s tel : %s", name, id, tel);
		System.out.println();
		
		String format = "name : {0}, id : {1}, tel : {2}";
		String result = MessageFormat.format(format, name, id, tel);
		System.out.println(result);
	}

}
