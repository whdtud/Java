package may25;

import java.util.Scanner;

/*
 * 능력 단위명 : 화면 구현
 * 능력단위요소 : UI 설계 확인하기
 */

public class DoWhile02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int java, jsp, spring, total;
		double avg;
		char grade;
		
		do {
			System.out.println("자바 점수를 입력하세요.");
			java = sc.nextInt();
		} while (java < 0 || java > 100);

		do {
			System.out.println("jsp 점수를 입력하세요.");
			jsp = sc.nextInt();
		} while (jsp < 0 || jsp > 100);
		
		do {
			System.out.println("spring 점수를 입력하세요.");
			spring = sc.nextInt();
		} while (spring < 0 || spring > 100);
		
		total = java + jsp + spring;
		avg = total / 3.0;
		
		switch ((int)avg / 10) {
			case 10:
			case 9: {
			grade = 'A';
			}
			break;
			case 8: {
				grade = 'B';
			}
			break;
			case 7: {
				grade = 'C';
			}
			break;
			default : {
				grade = 'F';
			}
			break;
		}

		System.out.printf("총점 : %d\n", total);
		System.out.printf("평균 : %.1f\n", avg);
		System.out.printf("학점 : %c", grade);		
		
		sc.close();
	}
}
