package days16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

class MiniGame extends JFrame implements ActionListener{
	JLabel com;
	JLabel user;
	JLabel result;
	MiniGame(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		//North- JLabel 1개 "준비가 되면 아래 가위바위보 중 하나를 선택하세요
		//FlowLayout 가운데 정렬
		JPanel p2 = new JPanel();//Center-JLabel 3개 : 컴퓨터가 낸 이미지 vs 사용자가 낸 이미지
		//FlowLayout 가운데 정렬
		JPanel p3 = new JPanel();//South-버튼 3개 "가위" "바위" "보"
		//FlowLayout 가운데 정렬
		
		Font f1 = new Font("굴림", Font.BOLD,30);
		Font f2 = new Font("굴림", Font.BOLD,18);
		JLabel l1 = new JLabel("가위/바위/보");
		JLabel l2 = new JLabel("-준비가 되면 아래 가위바위보 중 하나를 선택하세요");
		l1.setFont(f1);
		l2.setFont(f2);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 20,10));
		p1.add(l1); p1.add(l2);
		con.add(p1, BorderLayout.NORTH);
		
		com= new JLabel();
		user = new JLabel();
		ImageIcon icom= new ImageIcon("Images/0.jpg");
		ImageIcon iuser= new ImageIcon("Images/0.jpg");
		com.setIcon(icom);
		user.setIcon(iuser);
		JLabel vs = new JLabel("VS");
		vs.setFont(f1);
		Border b = new BevelBorder(BevelBorder.RAISED);
		com.setBorder(b);
		user.setBorder(b);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p2.add(com);
		p2.add(vs);
		p2.add(user);
		con.add(p2, BorderLayout.CENTER);
		
		
		JButton b1= new JButton("가위");
		JButton b2= new JButton("바위");
		JButton b3= new JButton("보");
		result= new JLabel("");
		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);
		result.setFont(f1);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p3.add(b1); p3.add(b2); p3.add(b3); p3.add(result);
		con.add(p3, BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		 
		setTitle("MiniGame");
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		int ComInt = (int)(Math.random()*3);
		String ComString;
		String resultString;
		String UserString;
		UserString = e.getActionCommand();
		
		if(ComInt == 0) ComString="가위";
		else if(ComInt==1) ComString="바위";
		else ComString="보";
		
		ImageIcon icom;//사용자와 컴퓨터가 낸 가위바위보 이미지를 표시 시작
		ImageIcon iuser;
		if(ComString.equals("가위")) icom= new ImageIcon("images/1_1.jpg");
		else if(ComString.equals("바위")) icom= new ImageIcon("images/2_1.jpg");
		else icom= new ImageIcon("images/3_1.jpg");
		if(UserString.equals("가위")) iuser= new ImageIcon("images/1_2.jpg");
		else if(UserString.equals("바위")) iuser= new ImageIcon("images/2_2.jpg");
		else iuser= new ImageIcon("images/3_2.jpg");
		com.setIcon(icom);
		user.setIcon(iuser); //사용자와 컴퓨터가 낸 가위바위보 이미지를 표시 끝
		
		if(UserString.equals(ComString)) resultString="무승부";
		else	if((UserString.equals("바위") &&ComString.equals("가위")) ||
				(UserString.equals("가위") &&ComString.equals("보"))	||
						(UserString.equals("보")&&ComString.equals("바위"))) {
			resultString="승리";
		}else resultString="패배";//승패결정
		
		result.setText(resultString);
		if(resultString.equals("승리")) result.setForeground(Color.red);
		else if (resultString.equals("패배")) result.setForeground(Color.black);
		else result.setForeground(Color.blue);//승패화면 표시
		
	}
}
public class Swing20 {

	public static void main(String[] args) {
		new MiniGame();
	}
}
