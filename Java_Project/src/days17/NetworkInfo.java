package days17;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInfo {

	public static void main(String[] args) {

		//IP 주소 : 네트워크에 접속되어 있는 (또는 인터넷에 연결 
//		지정된 숫자로 된 위치 정보 (주소)
		
		InetAddress ip = null;
		try {
			ip= InetAddress.getByName("www.daum.net");
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());
			System.out.println("toString() : "+ip.toString());
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
		ip = InetAddress.getLocalHost();//LocalHost:내컴퓨터
		System.out.println("getHostName() : " +ip.getHostName());
		System.out.println("getHostAddress() : " +ip.getHostAddress());
		//로컬호스트의 대표 아이피:127.0.0.1
		//http://localhost  http://127.0.0.1  http://192.168.0.70
	}catch ( UnknownHostException e) {
		e.printStackTrace();
	}

}}
