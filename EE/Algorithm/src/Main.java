import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		N1157();
	}
	
	public static void N2675()
	{
		/* 문자열 반복 
		 *문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
		 *즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. 
		 *S에는 QR Code "alphanumeric" 문자만 들어있다.

		 *QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] arrayR = new int[T];
		String[] arrayS = new String[T];
		
		for (int i = 0; i < T; i++) {
			arrayR[i] = sc.nextInt();
			arrayS[i] = sc.next();
		}
		
		for (int i = 0; i < T; i++) {
			String result = "";	
			for (int j = 0; j < arrayS[i].length(); j++) {
				for (int k = 0; k < arrayR[i]; k++) {
					result += arrayS[i].charAt(j);					
				}
			}
			System.out.println(result);
		}
		
		sc.close();
	}

	public static void N1157()
	{
		/* 단어 공부
		 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된
		 * 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
		 * 
		 * 입력) 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
		 * 출력) 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
		 * 단, 가장 많이 사용된 알파벳이 여러개 존재하는 경우에는 ?를 출력한다.
		 */
		
		Scanner cs = new Scanner(System.in);
		String input = cs.next();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char key = input.charAt(i);
			Integer value = map.getOrDefault(key, 0);
			value++;
		}
		
		char highestChar = '0';
		int highestValue = -1;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int value = entry.getValue(); 
			if (value > highestValue) {
				highestValue = value;
				highestChar = entry.getKey();
			}
		}
		
		
	}
}
