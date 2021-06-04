package jun04;

public class ErrorMessage extends Message {

	@Override
	public void setTxt(int errorCode) {
		txt = null;
		
		switch (errorCode) {
		case 1:
			txt = "메일 주소에 @가 없습니다.";
			break;
		case 2:
			txt = "ID의 길이가 5~10자 사이가 아닙니다.";
			break;
		case 3:
			txt = "첫 시작 문자가 대문자가 아닙니다.";
			break;
		case 4:
			txt = "ID가 영문자 또는 숫자가 아닙니다.";
			break;
		case 5:
			txt = "최상위 도메인이 올바르지 않습니다.";
			break;
		}
	}
	
	@Override
	public void print() {
		System.out.println("========Error=======");
		System.out.println(txt);
		System.out.println("====================");
	}
}
