package may31;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// 배열에 결과 저장
		
		// 저장
		
		// 몇 판
		
		// 반복
		
		// 배열에 승률 저장
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 번 반복하시겠습니까?");
		int count = sc.nextInt();
		int[] ranArr = new int[2];
		int[] resultArr = new int[2];
		
		for (int i = 0; i < count; i++) {
			
			for (int j = 0; j < ranArr.length; j++) {
				ranArr[j] = (int)(Math.random() * 3 + 1);
				System.out.printf("com%d : %d ", j, ranArr[j]);
			}
			System.out.println();
			
			// 3 - 2
			// 2 - 1
			// 1 - 3
			// 3 - 1
			// 2 - 3
			// 1 - 2
			
			if (ranArr[0] - ranArr[1] > 0 || ranArr[0] - ranArr[1] < -1) {
				resultArr[0]++;
			} else if (ranArr[0] < ranArr[1] || ranArr[0] - ranArr[1] > 1) {
				resultArr[1]++;
			} else {
			}
		}
		
		for (int i = 0; i < resultArr.length; i++) {
			System.out.printf("com%d winning rate : %f\n", i, resultArr[i] / (float)count);			
		}
		
		sc.close();
	}
}
