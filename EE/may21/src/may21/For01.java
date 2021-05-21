package may21;

/* 반복문
 * 자바에서는 필요에 따라서 특정 문장을 반복적으로 실행해야 할 때가 있습니다.
 * 이 때 사용되는 구문이 반복문 Loop문입니다.
 * 자바에서는 세가지 형태의 반복문을 제공합니다.
 * 
 * for(foreach), while, do~while입니다.
 * 
 */

public class For01 {
	
	public static void main(String[] args) {
		
		int total = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0)
				total += i;
		}
		
		System.out.println("총 합은 " + total);
	}
}
