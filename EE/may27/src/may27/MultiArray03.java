package may27;

import java.util.Scanner;

/* 성적 입력 및 출력하는 프로그램
 * 학생 이름도 입력받아서 같이 출력했으면 좋겠습니다.
 * 학생 이름, java, jsp, spring
 * 학생 이름, java점수, jsp점수, spring점수, 총점, 평균, 등급
 * 2차원 배열, 스위치, for, if
 */

public class MultiArray03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("please input student count.");
		int studentCount = sc.nextInt();
		
		String[] names = new String[studentCount];
		String[] subjects = {"java", "jsp", "spring"};
		int[][] scores = new int[studentCount][subjects.length];
		int[] sum = new int[names.length];
		float[] avg = new float[names.length];
		char[] grade = new char[names.length];
		
		for (int i = 0; i < names.length; i++) {
			System.out.print("please input name : ");
			names[i] = sc.next();
			for (int j = 0; j < subjects.length; j++) {
				System.out.printf("%s score : ", subjects[j]);
				scores[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < names.length; i++) {
			System.out.printf("name : %s", names[i]);
			
			for (int j = 0; j < subjects.length; j++) {
				
				System.out.printf(", %s : ", subjects[j]);
				System.out.printf("%d", scores[i][j]);
				
				sum[i] += scores[i][j];
			}

			avg[i] = (float)sum[i] / subjects.length;
			
			switch ((int)avg[i] / 10) {
			case 10:
			case 9:
				grade[i] = 'A';
				break;
			case 8:
				grade[i] = 'B';
				break;
			case 7:
				grade[i] = 'C';
				break;
			default:
				grade[i] = 'F';
				break;
				
			}
			
			System.out.printf(", total : %d, average : %.1f, grade : %c\n", sum[i], avg[i], grade[i]);			
		}
		
		
		sc.close();
	}
}