package chatting;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {

	public static void main(String[] args) {
		
		Scanner sc = null;
		Socket so = null;
		
		try {
			sc = new Scanner(System.in);
			so = new Socket("172.30.1.51", 5000);
			
			OutputStream os = so.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String text = "";
			
			while (true) {
				System.out.print("content : ");
				text = sc.next();
				bw.write(text + "\n");
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (so != null) so.close();
				if (sc != null) sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
