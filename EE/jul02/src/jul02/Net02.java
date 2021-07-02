package jul02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Net02 {

	public static void main(String[] args) {
		
		URL url = null;
		BufferedReader br = null;
		String addr = "https://www.naver.com";
		
		try {
			url = new URL(addr);
			InputStream is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
