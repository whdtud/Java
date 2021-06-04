package jun04;

public class Message {

	protected String txt;
	
	public String getTxt() {
		return txt;
	}
	
	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public void setTxt(int errorCode) {
	}
	
	public void print() {
		System.out.println("====================");
		System.out.println(txt);
		System.out.println("====================");
	}
}
