package jul02;

import java.net.InetAddress;
import java.util.Arrays;

public class Net03 {
	
	public static void main(String[] args) {
		
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName : " + ip.getHostName());
			System.out.println("getHostAddr : " + ip.getHostAddress());
			System.out.println("toString : " + ip.toString());
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress : " + Arrays.toString(ipAddr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName : " + ip.getHostName());
			System.out.println("getHostAddr : " + ip.getHostAddress());
			System.out.println("문자열로 : " + ip.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println(ipArr[i].toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
