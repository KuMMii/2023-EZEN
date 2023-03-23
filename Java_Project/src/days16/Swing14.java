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

class Calendars extends JFrame implements ActionListener{
	
	JTextField [] jt = new JTextField[42];
	JTextField y;
	JTextField m;
	
	Calendars(){
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
		
		
		for(int i = 0; i<42;i++){
			jt[i]=new JTextField();
			jt[i].setFont(f);
//			jt[i].setText((i+1)+"");
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
		y.setText(String.valueOf(today.get(Calendar.YEAR)));
		m.setText(String.valueOf(today.get(Calendar.MONTH)+1));
		//화면에 표시될 달력은 y,m 텍스트 필드를 기준으로 작정될 예정으로 그 숫자부터 넣음
		//추후에 다른 달 달력을 출력할 때도 y,m을 수정 후 그 달을 기준으로 달력 출력 예정
		
		drawCalendar();
		
		
		
		setTitle("Swing Calendar");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public void drawCalendar(){
		int year = Integer.parseInt(y.getText());
		int month = Integer.parseInt(m.getText()); //텍스트값을 정수로 변환
		
		for(int i=0; i<42; i++)jt[i].setText("");
		
		Calendar sday = Calendar.getInstance();
		Calendar eday = Calendar.getInstance();
		
		sday.set(year, month-1, 1);
		eday.set(year, month-1, sday.getActualMaximum(Calendar.DATE));
		
		
		
		int startWeek =sday.get(Calendar.DAY_OF_WEEK); //1일자의 요일(1:일요일~)
		//계산된 요일의 칸부터 출력(요일 결과 1: 일요일 0번째부터 1일로 출력, 요일 결과 2: 월요일 1번째부터 1일로 출력)
		for( int i=startWeek-1; (sday.before(eday))||(sday.equals(eday)); sday.add(Calendar.DATE, 1)) {
			//sday.before(eday)||(sday.equals(eday)) :시작날짜가 말일보다 작거나 같다면
			//sday.add(Calendar.DATE, 1)) : 시작 날짜를 1일씩 덧셈
			// 빈칸을 띄우거나 하는 동작 없이 해당 요일에 해당하는 i번째에 1일부터 출력
			int day =  sday.get(Calendar.DATE); //시작날짜에 일자만 추출
			jt[i].setText(String.valueOf(day));
			i++;
		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//이전달 다음달 버튼을 클릭하면 현재 달력이 이전달 다음달 달력으로 바뀌게 코딩함
		//새 달력이 출력될때 하단에 표시된 년월도 해당 년월로 수정
		//y,m 텍스트 필드 기준으로 달력이 출력되고 있으니 그 기준으로 바꿔기
		String s = e.getActionCommand();
		int year = Integer.parseInt(y.getText());
		int month = Integer.parseInt(m.getText());
		switch(s) {
		case "다음달" : 
//			//내가 한 버전
//			if(m.equals(12)) {
//				y.setText((Integer.parseInt(y.getText())+1)+"");
//				m.setText("1");
//			}else m.setText((Integer.parseInt(m.getText())+1)+"");
			//선생님
			if(month==12 ) {month =1; year++;}
			else month++;
			y.setText(year+"");
			m.setText(month+"");
			break;
			
		case "이전달" :
//			if(m.equals(1)) {
//				y.setText((Integer.parseInt(y.getText())-1)+"");
//				m.setText("12");
//			}else m.setText((Integer.parseInt(m.getText())-1)+"");
			//선생님 버전
			if(month==1 ) {month =12; year--;}
			else month--;
			y.setText(year+"");
			m.setText(month+"");
			break;
			
		case "확인" :
			JOptionPane aa = new JOptionPane();
			if(year<1||month>9999) {
				aa.showMessageDialog(null, "년도를 잘못 입력하셨습니다");
				y.setText(year+"");
			}
			if( month<1 || month>12 ) {
				aa.showMessageDialog(null, "월을 잘못 입력하셨습니다");
				m.setText(month+"");
			}	
		}
		drawCalendar();
	}
}
public class Swing14 {

	public static void main(String[] args) {
		new Calendars();
	}

}
