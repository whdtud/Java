package may21;

// overlap

/* API (Application Programming Interface) 
 * 애플리케이션 프로그래밍 인터페이스,
 * 응용 프로그램에서 사용할 수 있도록,
 * 운영 체제나 프로그래밍 언어가 제공하는
 * 기능을 제어할 수 있게 만든 인터페이스
 */

public class If06 {

	public static void main(String[] args) {
		
		char ch = 'A';
		
		if (Character.isUpperCase(ch)) {
			System.out.println("대문자입니다.");
		} else if (Character.isLowerCase(ch)) {
			System.out.println("소문자입니다.");
		} else if (Character.isDigit(ch)) {
			System.out.println("숫자입니다.");
		} else {
			System.out.println("특수문자입니다.");
		}
	}
}
