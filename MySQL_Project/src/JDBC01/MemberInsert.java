package JDBC01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import JDBC01.MemberDao;
import JDBC01.MemberDto;

class InsertForm extends JFrame implements ActionListener{

	JTextField name;
	JTextField phone;
	JTextField birth;
	JTextField gender;
	
	InsertForm(){
		
		Font f = new Font ("굴림", Font.BOLD,20);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		
		jp1.setLayout(new GridLayout(4,1));
		jp2.setLayout(new GridLayout(4,1));
		
		JLabel lb1 = new JLabel(" 성         명 : ");
		JLabel lb2 = new JLabel(" 전 화 번 호 : ");
		JLabel lb3 = new JLabel(" 생 년 월 일 : ");
		JLabel lb4 = new JLabel(" 성         별 : ");
		JButton title = new JButton("***회 원 추 가***");
		
		lb1.setFont(f);	
		lb2.setFont(f);	lb3.setFont(f);	lb4.setFont(f);
		jp1.add(lb1);	jp1.add(lb2);	jp1.add(lb3);	jp1.add(lb4);
		con.add(jp1, BorderLayout.WEST);
		
		name = new JTextField();		phone=new JTextField();
		birth= new JTextField();		gender=new JTextField();
		name.setFont(f);   phone.setFont(f);   birth.setFont(f);   gender.setFont(f);
		jp2.add(name);		jp2.add(phone); 	jp2.add(birth);	jp2.add(gender);
		con.add(jp2, BorderLayout.CENTER);
		
		JButton jb = new JButton("추가");
		jb.setFont(f);
		con.add(jb, BorderLayout.SOUTH);
		
		title.setFont(f);
		con.add(title, BorderLayout.NORTH);
		
		jb.addActionListener(this);
		
		setTitle("Adding Records");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDto mdto = new MemberDto();
		
		if(name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "이름을 입력하세요");
			return;
		}
		if(phone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;
		}
		if(birth.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "생년월일을 입력하세요");
			return;
		}
		if(gender.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "성별을 입력하세요");
			return;
		}
		
		
		mdto.setName(name.getText());
		mdto.setPhone(phone.getText());
		mdto.setBirth(birth.getText());
		mdto.setGender(gender.getText());
		
		Calendar today = Calendar.getInstance();
		int todayYear = today.get(Calendar.YEAR);
		int birthYear=Integer.parseInt(birth.getText().substring(0, 4));
		mdto.setAge(todayYear-birthYear);
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);

		
		
		
		
		
		
		
		if(result==1) {
			JOptionPane.showMessageDialog(null, "Success");
			name.setText(""); phone.setText(""); birth.setText("");  gender.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
	
}
public class MemberInsert {

	public static void main(String[] args) {
		new InsertForm();
	}
}
