package may25;

import java.util.Arrays;

public class Array03 {

	public static void main(String[] args) {
		
		char[] cArr01 = new char[26];
		
		char alpha = 'A';
		for (int i = 0; i < cArr01.length; i++) {
			cArr01[i] = alpha++;
		}
		
		System.out.println(Arrays.toString(cArr01));
		
		for (char c : cArr01) {
			System.out.println(c);
		}
		
		System.out.println();
		
		char[] cat = {'C', 'A', 'T'};
		
		System.out.println((char)(cat[0] + 5));
		System.out.println((char)(cat[1] + 5));
		System.out.println((char)(cat[2] + 5));
		
		for (int i = 0; i < cat.length; i++) {
			System.out.println((char)(cat[i] + 3));
		}
	}
}
