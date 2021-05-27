package may27;

/* 1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
 *8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
 *(※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 함) 
 */

public class Google {

	public static void main(String[] args) {
		Case01();
	}
	
	public static void Case01() {
		
		int count = 0;
		for (int i = 1; i < 10001; i++) {
			int number = i;
			
			while (number > 0) {
				if (number % 10 == 8) {
					count++;
				}
				number = number / 10;
			}
		}
		
		System.out.println(count);
	}
	
	public static void Case02() {
		
	}
}
