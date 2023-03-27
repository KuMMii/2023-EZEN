package days18;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer02 {

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}// [hh:mm:ss] 이 양식으로 현재 시간을 String으로 리턴하는 메서드
	
	public static void main(String[] args) {

		ServerSocket ss = null;//참조변수 생성
		
		try {
			ss= new ServerSocket(6666);//서버소켓의 객체 생성
			System.out.println(getTime()+"서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} 
		while(true) {
			try {
				System.out.println(getTime()+"연결요청을 기다립니다.");
				ss.setSoTimeout(1500);
				//서버 소켓이 클라이언트 요청을 기다리는 시간 설정
				//설정된 시간이 지날때까지 요청이 없으면 SocketTimeoutException 예외가 발생함
				Socket s =ss.accept();//서버소켓이 연결을 기다리다가 요청을 감지하면 accept()가 실행됨
				System.out.println(getTime()+""+ s.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out); //최종 통신 출력 도구 : dos
				dos.writeUTF("[공지] : 연결성공~! 204호 11번 서버에 접속되셨습니다."); //메세지를 보내는 메소드
				System.out.println(getTime()+"데이터를 전송했습니다.");
				dos.close();
				s.close();
			}catch(SocketTimeoutException e) {
				System.out.println(getTime()+"접속시간 초과. 서버종료");
				System.exit(0); //return대신 사용할수 있는 프로그램 종료 명령
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

}
