package days18;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient01 {

	public static void main(String[] args) {

		String serverIP= "192.168.0.120";
		
			try {
				Socket s = new Socket(serverIP, 6666);
//				Socket :클라이언트가 연결을 요청할 소프트웨어
//				serverIp:클라이언트가 요청할 연결의 목적지 주소
//				7777: 서버에서 관리할 연결의 그룹번호
//				객체가 만들어지는 순간 써놓은 아이피와 포트번호로 연결을 요청
				
				InputStream in = s.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				
				//연결된 서버로부터 전달된 메세지를 저장함
				String m = dis.readUTF();
				
				//소켓으로부터 받은 데이터를 출력
				System.out.println("받은 메시지 : "+m);
				System.out.println("연결을 종료합니다.");
				//스트림과 소켓을 닫습니다
				dis.close();
				s.close();
				System.out.println("연결종료");
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
