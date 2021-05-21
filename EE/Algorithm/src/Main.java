import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		N2675();
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
}
