package jul02;

import java.net.URL;
import java.net.URLConnection;

public class Net04 {

	public static void main(String[] args) {
		URL url = null;
		
		try {
			url = new URL("");
			URLConnection conn = url.openConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
