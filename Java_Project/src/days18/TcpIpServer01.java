package days18;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer01 {

	public static void main(String[] args) {
		

		//서버와 클라이언트의 연결을 가능하게 해주는 클래스
		ServerSocket ss = null;//참조변수 생성
		//클라이언트의 요청이 오면 연결해주마!의 뜻이 있는 클래스
		
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		//클라이언트에게 보낼 현재시각의 양식
		
		try {
			ss= new ServerSocket(6666);//서버소켓의 객체 생성
			//위 문장이 실행되면 서버가 클라이언트의 연결요청을 기다리며, 수락할 준비가 완료됨
			//7777: 클라이언트가 접속 요청하는 포트번호. 포트번호는 반드시 7777이 아니어도 되고,
			//자유롭게 설정해 포트번호를 알고 있는 클라이언트만 접속하게도 할 수 있음
			System.out.println(f.format(new Date())+"서버가 준비되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} 
		
		while(true) {
			try {
				//서버소켓은 준비 완료 이후 클라이언트의 연결요청이 올 때까지 실행을 잠시 멈추고 계속 기다림
				System.out.println(f.format(new Date())+"연결요청을 기다립니다.");
				//현재 위치에서 접속이 있을 때 까지 대기하다가 
				Socket s =ss.accept();//서버소켓이 연결을 기다리다가 요청을 감지하면 accept()가 실행됨
				//accept()가 실행되고, 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 통신용 소켓(s)을 연결정보와 함께 생성하고, 
				//소켓이 요청받은 클라이언트 연결정보를 전달함
				System.out.println(f.format(new Date())+ s.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				//s 소켓에서 연결된 클라이언트에게 보낼 메세지를 클라이언트로 출력해줄 출력전송스트림 객체를 꺼냄
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out); //최종 통신 출력 도구 : dos
				dos.writeUTF("[공지] : 연결성공~! 204호 11번 서버에 접속되셨습니다."); //메세지를 보내는 메소드
				
				System.out.println(f.format(new Date())+"메세지를 전송했습니다.");
				dos.close();
				s.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		static String getTime() {
			SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
			return f.format(new Date());
		}// [hh:mm:ss] 이 양식으로 현재 시간을 String으로 리턴하는 메서드
		
	}

}









