package may21;

import java.util.Scanner;

/* 지금까지 우리가 배운 것 - 4일차
 * 자바 설치, OracleJDK, OpenJDK
 * JDK = Java Development Kit (Include JRE)
 * JRE = Java Runtime Environment (Include JVM)
 * JVM = Java Virtual Machine
 * 
 * Variable = Changing Value
 * Constant = final
 * 
 * Orthography
 * 		Pascal = First character is upper case. Use to class name.
 * 		Camel = First character is lower case.
 * 		Snake = Use upper case, Put underbar between words.
 * 
 * DataType
 * 		Primitive
 * 			byte, short, int, long, float, double, char, boolean
 * 		Reference
 * 			All types except primitive type.
 * 
 * DataType casting
 * 		Promotion, cast
 * 
 */

public class Input01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		
		int input = sc.nextInt();
		
		if (input % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
		sc.close();
	}
}
