package may21;

import java.util.Scanner;

// 사용자가 입력한 숫자만큼 구구단 2단 출력하기

public class For04 {

	public static void main(String[] args) {
		
		System.out.println("숫자를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for (int i = 2; i <= input; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " x " + j + " = " + i * j);
			}
			System.out.println();
		}
	}
}
