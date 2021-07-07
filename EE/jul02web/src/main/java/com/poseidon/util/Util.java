package com.poseidon.util;

public class Util {
	// 방법1
	public static int str2Int(String str) {
		// 120A이렇게 들어온다면 120을 리턴해줍니다.
		int result = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				temp += str.charAt(i);
			}
		}
		result = Integer.parseInt(temp);
		return result;
	}

	// 방법2
	public static int str2Int2(String str) {

		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}

	}

}
/*
 * 입실/퇴실 카드 꼭 찍어주세요.
 * 퇴실하실때 안 찍으시면
 * 컴퓨터 계속 켜 둬야 합니다. ㅠㅠ
 * 오늘 출근해서 컴퓨터 껐어요 ;;;;;
 * 
 * 
 */













