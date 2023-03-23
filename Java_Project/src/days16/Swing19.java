package days16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Cal extends JFrame implements ActionListener{
	
	JTextField [] jt = new JTextField[42];
	
	JComboBox<String> y;
	JComboBox<String> m;
	
	Cal(){
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
		
		

		JButton bb1 = new JButton("이전달");
		bb1.setFont(f);
		JButton bb2 = new JButton("다음달");
		bb2.setFont(f);
		JButton bb3 = new JButton("확인");
		bb3.setFont(f);
		
//		y,m에 콤보상자 인스턴스를 만들고, 년도는 1900~2030년까지	m은 1~12로 표시하기
		y = new JComboBox<String>();
		m = new JComboBox<String>();
		for(int i=1900; i<=2030; i++)
			y.addItem(i+"");
		for(int i=1;i<=12;i++) m.addItem(i+"");
		
		
		y.setFont(f);
		m.setFont(f);
		JLabel sy =new JLabel("년");
		sy.setFont(f);
		JLabel sm=new JLabel("월");
		sm.setFont(f);
		
		jp3.add(bb1); jp3.add(y); jp3.add(sy); jp3.add(m); jp3.add(sm); jp3.add(bb3); jp3.add(bb2);
		con.add(jp3, BorderLayout.SOUTH);
		
		bb1.addActionListener(this);
		bb2.addActionListener(this);
		bb3.addActionListener(this);
		
		
		for(int i = 0; i<42;i++){
			jt[i]=new JTextField();
			jt[i].setFont(f);
			jt[i].setHorizontalAlignment(SwingConstants.RIGHT); //텍스트 표시 오른쪽 정렬
			if(i%7==6) jt[i].setForeground(Color.BLUE); // 토요일 파란색 글자
			else if ( i%7==0)jt[i].setForeground(Color.RED); //일요일 빨간색
			else jt[i].setForeground(Color.black); //평일 나머지 검정색 글자
			jt[i].setEditable(false);
			jt[i].setBackground(Color.white);
			jp2.add(jt[i]);
		}
		con.add(jp2, BorderLayout.CENTER);
		
		Calendar today = Calendar.getInstance();
		y.setSelectedIndex(today.get(Calendar.YEAR)-1900); //순서는 0부터니까
		m.setSelectedIndex(today.get(Calendar.MONTH));
		//화면에 표시될 달력은 y,m 텍스트 필드를 기준으로 작정될 예정으로 그 숫자부터 넣음
		//추후에 다른 달 달력을 출력할 때도 y,m을 수정 후 그 달을 기준으로 달력 출력 예정
		
		drawCalendar();
		
		
		
		setTitle("Swing Calendar");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public void drawCalendar(){
		int year = Integer.parseInt((String)y.getSelectedItem());
		int month = Integer.parseInt((String)m.getSelectedItem());
		
		for(int i=0; i<42; i++)jt[i].setText("");
		
		Calendar sday = Calendar.getInstance();
		Calendar eday = Calendar.getInstance();
		
		sday.set(year, month-1, 1);
		eday.set(year, month-1, sday.getActualMaximum(Calendar.DATE));
		
		
		
		int startWeek =sday.get(Calendar.DAY_OF_WEEK); //1일자의 요일(1:일요일~)
		for( int i=startWeek-1; (sday.before(eday))||(sday.equals(eday)); sday.add(Calendar.DATE, 1)) {
			int day =  sday.get(Calendar.DATE); //시작날짜에 일자만 추출
			jt[i].setText(String.valueOf(day));
			i++;
		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = (String)e.getActionCommand();
		int year = Integer.parseInt((String)y.getSelectedItem());
		int month = Integer.parseInt((String)m.getSelectedItem());
		switch(s) {
		case "다음달" : 
			if(month==12 ) {month =1; year++;}
			else month++;
			break;
			
		case "이전달" :
			if(month==1 ) {month =12; year--;}
			else month--;
			break;
			
		case "확인" :
		}
		y.setSelectedIndex(year-1900);
		m.setSelectedIndex(month-1);
		drawCalendar();
	}
}
public class Swing19 {

	public static void main(String[] args) {
		new Cal();
	}

}
