package jul02;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientSocket {
	
	public static void main(String[] args) {
		String serverIp = "localhost";
		System.out.println(serverIp + " connecting to server..");
		
		try {
			Socket socket = new Socket(serverIp, 5000);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("server message : " + dis.readUTF());
			System.out.println("exit");
			
			dis.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
