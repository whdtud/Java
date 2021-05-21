package may21;

/* 1. 랜덤한 값 두개 생성합니다.
 * 2. if문으로 크기를 비교합니다. (자리바꾸기 해주세요)
 * 3. 큰 수부터 출력해주세요.
 * 
 * 1. 5
 * 2. 8
 * 1 + ">" + 2
 */

public class If04 {

	public static void main(String[] args)
	{
		int random1 = (int)(Math.random() * 10 + 1);
		int random2 = (int)(Math.random() * 10 + 1);
		
		// 정렬
		int temp = -1;
		if (random2 > random1)
		{
			temp = random1;
			random1 = random2;
			random2 = temp;
		}
		
		System.out.println(random1 + ">" + random2);
	}
}
