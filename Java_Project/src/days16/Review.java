package days16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.SwingConstants;

class C1 extends JFrame implements ActionListener{
	
	
	JTextField [] jt = new JTextField[42];
	JTextField y;
	JTextField m;
		C1(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		 
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(1,7)); //일 월 화 수 목 금 토 맨윗줄 요일이 표시될 부분
		jp2.setLayout(new GridLayout(6,7)); //달력이 표시될 부분
		jp3.setLayout(new FlowLayout()); //현재 달력의 년 월이 표시될 부분
		
		Font f = new Font("굴림", Font.BOLD,20);
		JButton b1 = new JButton("일");
		b1.setFont(f);
		JButton b2 = new JButton("월");
		b2.setFont(f);
		JButton b3 = new JButton("화");
		b3.setFont(f);
		JButton b4 = new JButton("수");
		b4.setFont(f);
		JButton b5 = new JButton("목");
		b5.setFont(f);
		JButton b6 = new JButton("금");
		b6.setFont(f);
		JButton b7 = new JButton("토");
		b7.setFont(f);
		
		jp1.add(b1).setForeground(Color.RED);
		jp1.add(b2);
		jp1.add(b3);
		jp1.add(b4);
		jp1.add(b5);
		jp1.add(b6);
		jp1.add(b7).setForeground(Color.BLUE);
		
		con.add(jp1, BorderLayout.NORTH);
		
		for(int i =0 ; i<jt.length;i++) {
			jt[i]= new JTextField();
			jt[i].setFont(f);
			jt[i].setHorizontalAlignment(SwingConstants.RIGHT);
			if(i%7==6) jt[i].setForeground(Color.blue);
			else if(i%7==0) jt[i].setForeground(Color.red);
			else jt[i].setForeground(Color.black);
			jt[i].setEditable(false);
			jt[i].setBackground(Color.white);
			jp2.add(jt[i]);
		}
		
		
		JButton bb1 = new JButton("이전달");
		bb1.setFont(f);
		JButton bb2 = new JButton("다음달");
		bb2.setFont(f);
		JButton bb3 = new JButton("확인");
		bb3.setFont(f);
		y= new JTextField(6);
		m= new JTextField(3);
		y.setFont(f);
		y.setHorizontalAlignment(SwingConstants.CENTER);
		m.setFont(f);
		m.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel sy =new JLabel("년");
		sy.setFont(f);
		JLabel sm=new JLabel("월");
		sm.setFont(f);
		
		jp3.add(bb1); jp3.add(y); jp3.add(sy); jp3.add(m); jp3.add(sm); jp3.add(bb3); jp3.add(bb2);
		con.add(jp3, BorderLayout.SOUTH);
		
		bb1.addActionListener(this);
		bb2.addActionListener(this);
		bb3.addActionListener(this);

		con.add(jp2, BorderLayout.CENTER);
		
		Calendar today =Calendar.getInstance();
		y.setText(String.valueOf(today.get(Calendar.YEAR)));
		m.setText(String.valueOf(today.get(Calendar.MONTH)+1));
		
		drawCalendar();
		
		setTitle("Swing Calendar");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
		
	public void drawCalendar() {
		
		int year=Integer.parseInt(y.getText());
		int month = Integer.parseInt(m.getText());
		
		for(int i =0; i<jt.length; i++ ) jt[i].setText("");
		
		Calendar sday =Calendar.getInstance();
		Calendar eday =Calendar.getInstance();
		
		sday.set(year, month-1, 1);
		eday.set(year, month-1, sday.getActualMaximum(Calendar.DATE));
		
		int startWeek = sday.get(Calendar.DAY_OF_WEEK);
		
		for(int i=startWeek-1; (sday.before(eday))||(sday.equals(eday));
				sday.add(Calendar.DATE,1)) {
			int day = sday.get(Calendar.DATE);
			jt[i].setText(String.valueOf(day));
			i++;
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		int year = Integer.parseInt(y.getText());
		int month=Integer.parseInt(m.getText());
		switch(s) {
			case ("다음달"):
				if(month==12) {
					year++; month=1;
				}
				else 	month++;
			y.setText(year+"");
			m.setText(month+"");
			break;
			case ("이전달"):
				if(month==1) {
					year--; month=12;
				}
				else 	month--; 
				y.setText(year+"");
				m.setText(month+"");
				break;
			case("확인"):
				JOptionPane aa = new JOptionPane();
				if(year<1||year>9999) {
					aa.showMessageDialog(null, "년도 오류");
					y.setText(year+"");
				}
				if(month<1||month>12) {
					aa.showMessageDialog(null, "월 오류");
					m.setText(year+"");
				}
		
		}
		drawCalendar();
		
	}
	
}
public class Review {

	public static void main(String[] args) {
		new C1();
	}

}
