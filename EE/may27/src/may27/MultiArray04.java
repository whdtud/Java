package may27;

import java.util.Arrays;

public class MultiArray04 {

	public static void main(String[] args) {
		Case02();
	}
	
	public static void Case01() {

		int[][] arr01 = new int[3][3];
		
		for (int i = 0; i < arr01.length; i++) {
			for (int j = 0; j < arr01[i].length; j++) {
				arr01[i][j] = j + 1 + i * arr01[i].length;
			}
		}
		
		for (int i = 0; i < arr01.length; i++) {
			for (int j = 0; j < arr01[i].length; j++) {
				int row01 = (int)(Math.random() * 3);
				int column01 = (int)(Math.random() * 3);
				
				int row02 = (int)(Math.random()) * 3;
				int column02 = (int)(Math.random()) * 3;
				
				int temp = arr01[row01][column01]; 
				arr01[row01][column01] = arr01[row02][column02];
				arr01[row02][column02] = temp;
			}
		}
		
		for (int i = 0; i < arr01.length; i++) {
			System.out.println(Arrays.toString(arr01[i]));	
		}				
	}
	
	public static void Case02() {

		int[][] arr01 = new int[3][3];
		
		for (int i = 0; i < arr01.length; i++) {
			for (int j = 0; j < arr01[i].length; j++) {
				arr01[i][j] = (int)(Math.random() * 9) + 1;
				
				boolean isDuplicated = false;
				for (int i2 = 0; i2 <= i; i2++) {
					for (int j2 = 0; j2 < arr01[i].length; j2++) {
						
						int index01 = j + i * arr01.length;
						int index02 = j2 + i2 * arr01.length;
						
						if (index01 == index02) {
							break;
						}
						
						if (arr01[i][j] == arr01[i2][j2]) {
							isDuplicated = true;
							System.out.printf("[%d][%d], [%d][%d] is duplicated. value : %d\n", i, j, i2, j2, arr01[i][j]);
							break;
						}
					}
					
					if (isDuplicated == true) {
						j--;
						break;
					}
				}
			}
		}

		for (int i = 0; i < arr01.length; i++) {
			System.out.println(Arrays.toString(arr01[i]));	
		}
	}
}
