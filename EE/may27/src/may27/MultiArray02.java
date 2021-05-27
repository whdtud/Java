package may27;

import java.util.Arrays;
import java.util.Scanner;

// 2차원 배열 : 배열 속에 배열이 있습니다.

public class MultiArray02 {

	public static void main(String[] args) {
		
		int[][] multiArr01 = new int[2][4];

		/* [1][2][3][4]
		 * [5][6][7][8]
		 */
		
		for (int i = 0; i < multiArr01.length; i++) {
			for (int j = 0; j < multiArr01[i].length; j++) {
				System.out.print(multiArr01[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("==============================");
		
		System.out.println(Arrays.toString(multiArr01));
		//[[I@2401f4c3, [I@7637f22]
		
		for (int i = 0; i < multiArr01.length; i++) {
			System.out.println(Arrays.toString(multiArr01[i]));	
		}
		
		for (int[] is : multiArr01) {
			System.out.println(Arrays.toString(is));
		}
		
		for (int i = 0; i < multiArr01.length; i++) {
			for (int j = 0; j < multiArr01[i].length; j++) {
				multiArr01[i][j] = j + 1 + i * multiArr01[i].length;
			}
		}
		
		for (int[] is : multiArr01) {
			System.out.println(Arrays.toString(is));			
		} 
	}
}
