package chatting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
			System.out.println("server opened");
			serverSocket = new ServerSocket(5000);
			Socket socket = serverSocket.accept();
			System.out.println("connect success");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.println(br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
