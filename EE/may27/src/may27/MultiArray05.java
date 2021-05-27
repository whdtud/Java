package may27;

import java.util.Arrays;

public class MultiArray05 {

	public static void main(String[] args) {
		
		int[][] three = new int[3][3];
		
		for (int i = 1; i < 10; i++) {
			int r1 = (int)(Math.random() * 3);
			int r2 = (int)(Math.random() * 3);
			
			if (three[r1][r2] == 0) {
				three[r1][r2] = i;
			} else {
				i--;
				System.out.println(r1 + " : " + r2 + " duplicated");
			}
		}
		
		for (int[] is : three) {
			System.out.println(Arrays.toString(is));			
		}
	}
}
