import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient031 {

	public static void main(String[] args) {

		String serverip = "192.168.0.120";
		
		try {
			Socket s = new Socket(serverip, 6666);
			System.out.println("������ ����Ǿ����ϴ�.");
			
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();
			receiver.start();

			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
