package jun04;

import java.util.Scanner;

// 사용자가 메일 주소를 입력하기

// 진짜 메일 주소가 맞는지 검사하기 = @, .com, .co.kr, .net, .org

// 입력받은 email 값을 @기준으로 분리하세요
// @앞 값은 id라는 변수에 담아주세요
// @뒤 값은 server라는 변수에 담아주세요
// @가 없는 email 이라면 "이메일을 입력하세요" 라고 뜨게 해주세요
// 올바른 이메일인 경우 분리된 id를 아래와 같이 조건에 부합되게 만들어주세요.

/*
 * 1. id의 길이는 5~10자 이어야 합니다. 
 * 2. 첫 문자는 반드시 영어 대문자이어야 합니다. 
 * 3. 나머지 문자는 영문자와 숫자로만 구성되어야 합니다. 
 * 4. 모든 조건에 맞으면 "올바른 ID입니다" 라고 출력해주세요 
 * 5. 위 조건에 맞지 않는다면 틀린 이유를 출력시키고
 * 프로그램 종료해주세요.
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("이메일 주소를 입력해주세요 : ");
		String input = sc.next();
		
		//ProceduralProcess(input);
		
		//FunctionalProcess(input);
		
		ObjectOrientedProcess(input);
		
		sc.close();
	}
	
	private static void ProceduralProcess(String input) {
		// 아이디와 주소 분리
		String[] datas = input.split("@");
		if (datas.length < 2) {
			System.out.println("이메일을 정확히 입력하세요.");
		}
		
		String id = datas[0];
		String server = datas[1];
		String error = null;
		
		// 에러 체크
	    // 1. id의 길이는 5~10자 이어야 합니다. 
		if (id.length() >= 5 && id.length() <= 10) {
			// 2. 첫 문자는 반드시 영어 대문자이어야 합니다.
			if (Character.isUpperCase(id.charAt(0)) == true) {
				// 3. 나머지 문자는 영문자와 숫자로만 구성되어야 합니다.
				boolean pass = true;
				for (int i = 1; i < id.length(); i++) {
					char ch = id.charAt(i);
					if (Character.isLetterOrDigit(ch) == false) {
						pass = false;
						error = "ID가 영문자 또는 숫자가 아닙니다.";
						break;
					}
				}
			} else {
				error = "첫 시작 문자가 대문자가 아닙니다.";
			}
		} else {
			error = "ID의 길이가 5~10자 사이가 아닙니다.";
		}
		
		// 진짜 메일 주소가 맞는지 검사하기 = @, .com, .co.kr, .net, .org
		String[] endDomains = {".com", ".co.kr", ".net", ".org"};
		boolean pass = false;
		for (int i = 0; i < endDomains.length; i++) {
			if (server.endsWith(endDomains[i])) {
				pass = true;
				break;
			}
		}

		if (pass == false) {
			error = "최상위 도메인이 올바르지 않습니다.";
		}
		
		if (error != null) {
			System.out.println(error);
		} else {
			System.out.println("올바른 ID입니다.");
		}
	}
	
	private static void FunctionalProcess(String input) {
		
		int errorCode = checkError(input);
		String message = getErrorMessage(errorCode);
		
		if (message == null) {
			System.out.println("올바른 ID입니다.");
		} else {
			System.out.println(message);
		}
	}
	
	private static int checkError(String input) {
		
		String[] datas = input.split("@");
		if (datas.length < 2) {
			return 1;
		}
		
		String id = datas[0];
		String server = datas[1];
 
		if (id.length() < 5 && id.length() > 10) {
			return 2;
		}
			
		if (Character.isUpperCase(id.charAt(0)) == false) {
			return 3;
		}
		
		for (int i = 1; i < id.length(); i++) {
			char ch = id.charAt(i);
			if (Character.isLetterOrDigit(ch) == false) {
				return 4;
			}
		}
		
		String[] endDomains = {".com", ".co.kr", ".net", ".org"};
		boolean pass = false;
		for (int i = 0; i < endDomains.length; i++) {
			if (server.endsWith(endDomains[i])) {
				pass = true;
				break;
			}
		}
		
		if (pass == false) {
			return 5;
		}
		
		return 0;
	}
	
	private static String getErrorMessage(int errorCode) {
		String msg = null;
		switch (errorCode) {
		case 1:
			msg = "메일 주소에 @가 없습니다.";
			break;
		case 2:
			msg = "ID의 길이가 5~10자 사이가 아닙니다.";
			break;
		case 3:
			msg = "첫 시작 문자가 대문자가 아닙니다.";
			break;
		case 4:
			msg = "ID가 영문자 또는 숫자가 아닙니다.";
			break;
		case 5:
			msg = "최상위 도메인이 올바르지 않습니다.";
			break;
		}
		return msg;
	}
	
	private static void ObjectOrientedProcess(String input) {
		int errorCode = checkError(input);
		Message msg = new ErrorMessage();
		msg.setTxt(errorCode);
		
		if (msg.getTxt() != null) {
			msg.print();	
		}
	}
}
