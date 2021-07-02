package jul02;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Socket01 {

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println(getTime() + " connect success.");

			while (true) {
				System.out.println(getTime() + " waiting for connect..");
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + " received request");
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				dos.writeUTF("this message is from server.");
				System.out.println(getTime() + " send message.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
