package may21;

import java.util.Scanner;

public class If07 {

	public static final int GA_WE = 1;
	public static final int BA_WE = 2;
	public static final int BO = 3;
	
	public static void main(String[] args) {
		
		// 1. 사용자의 입력 받기
		System.out.println("1. 가위\t2. 바위\t3. 보");
		System.out.println("원하는 번호를 눌러주세요.");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		// 2. 컴퓨터 숫자 저장하기
		int random = (int)(Math.random() * BO + 1);
		
		// 3. 판정하기 & 출력하기
		if (random - input > 1 || random - input < -1) {
			if (random == GA_WE) {
				System.out.println("컴퓨터가 이겼습니다.");
			} else {
				System.out.println("당신이 이겼습니다.");
			}
		}
		else if (random > input) {
			System.out.println("컴퓨터가 이겼습니다.");
		} else if (random == input){
			System.out.println("비겼습니다.");
		} else {
			System.out.println("당신이 이겼습니다.");
		}
		
		System.out.println("computer : " + random + ", player : " + input);
	}
}
