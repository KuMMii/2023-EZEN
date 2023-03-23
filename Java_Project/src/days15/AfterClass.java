package days15;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//컨테이너의 레이아웃 : 5행 1열의 GridLayout
//1행 : JPanel p1 배치 ->p1 에는 GridLayout으로 TextField 한개 배치
//2행 : JPanel p2 배치 ->p2 에는 GridLayout으로 버튼 네개(7,8,9,+)
//3행 : JPanel p3 배치 ->p3 에는 GridLayout으로 버튼 네개(4,5,6,-)
//4행 : JPanel p4 배치 ->p4 에는 GridLayout으로 버튼 네개(1,2,3,x)
//5행 : JPanel p5 배치 ->p5 에는 GridLayout으로 버튼 네개(C,0,=,÷)
class Cal extends JFrame implements ActionListener{
	JTextField t1;
	String operator;
	int firstNumber;
	int secondNumber;
	Cal(){
		Container con = getContentPane();
		con.setLayout(new GridLayout(6,1));
		
		Font f = new Font("굴림", Font.BOLD,20);
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		
		p1.setLayout(new GridLayout(1,1));
		t1=new JTextField(15);
		t1.setFont(f);
		t1.setHorizontalAlignment(SwingConstants.RIGHT);
		t1.setEditable(false);
		t1.setText("0");
		con.add(p1.add(t1));
		
		p2.setLayout(new GridLayout(1,4));
		JButton b7= new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bplus = new JButton("+");
		b7.setFont(f);
		b8.setFont(f);
		b9.setFont(f);
		bplus.setFont(f);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(bplus);
		con.add(p2);
		
		p3.setLayout(new GridLayout(1,4));
		JButton b4= new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bmin = new JButton("-");
		b4.setFont(f);
		b5.setFont(f);
		b6.setFont(f);
		bmin.setFont(f);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(bmin);
		con.add(p3);
		
		p4.setLayout(new GridLayout(1,4));
		JButton b1= new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bmul = new JButton("x");
		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		bmul.setFont(f);
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(bmul);
		con.add(p4);
		
		p5.setLayout(new GridLayout(1,4));
		JButton bC = new JButton("C");	
		JButton b0 = new JButton("0");
		JButton beq = new JButton("=");
		JButton bdi = new JButton("÷");
		bC.setFont(f);
		b0.setFont(f);
		beq.setFont(f);
		bdi.setFont(f);
		p5.add(bC);
		p5.add(b0);
		p5.add(beq);
		p5.add(bdi);
		con.add(p5);
		
		p6.setLayout(new GridLayout(1,4));
		JButton bb = new JButton("<-");	
		JButton b10 = new JButton("sqr");
		JButton b11 = new JButton("1/x");
		JButton b12 = new JButton("X*X");
		bb.setFont(f);
		b10.setFont(f);
		b11.setFont(f);
		b12.setFont(f);
		p6.add(bb);
		p6.add(b10);
		p6.add(b11);
		p6.add(b12);
		con.add(p6);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		bb.addActionListener(this);
		bC.addActionListener(this);
		
		bplus.addActionListener(this);
		bmin.addActionListener(this);
		bdi.addActionListener(this);
		bmul.addActionListener(this);
		beq.addActionListener(this);
		
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		
		setTitle("Calculator");
		setSize( 400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s= e.getActionCommand();
		String oldText="";
		oldText=t1.getText();
		DecimalFormat df=new DecimalFormat("#.####");

		switch(s) {
		case "0" : case "1" : 	case "2" : case "3" : case "4" : case "5" : case "6" : 
		case "7" : case "8" : case "9" : 
			if(oldText.equals("0")) oldText="";
			t1.setText(oldText+s);
			break;
		
		case "C" : t1.setText("0"); break;
		case "<-":
			if(oldText.length()==1) t1.setText("0");
			else {
				String newText = oldText.substring(0,oldText.length()-1);
				t1.setText(newText);
			}break;
		case "+":	case "-":	case "x":	case "÷":  
			operator=s;
			firstNumber= Integer.parseInt(t1.getText());
			t1.setText("0");
			break;
		case "=":
			secondNumber=Integer.parseInt(t1.getText());
			switch(operator) {
				case "+":
					t1.setText(String.valueOf(firstNumber+secondNumber));
				case "-":
					t1.setText(String.valueOf(firstNumber-secondNumber)); break;
				case "x":
					t1.setText(String.valueOf(firstNumber*secondNumber)); break;
				case "÷":
					t1.setText(String.valueOf(df.format(firstNumber/(double)secondNumber)));
					break;
			}
			break;
			
		case "sqr" :
			secondNumber=Integer.parseInt(t1.getText());
			if(secondNumber==0) return;
			double d = Math.sqrt(secondNumber);
			t1.setText(String.valueOf(df.format(d)));break;
		case "1/x" :
			secondNumber=Integer.parseInt(t1.getText());
			if(secondNumber==0) return;
			d=1.0/secondNumber;
			t1.setText(String.valueOf(df.format(d))); break;
		case "X*X" :
			secondNumber=Integer.parseInt(t1.getText());
			t1.setText(String.valueOf(secondNumber*secondNumber)); break;
		}
		
	}
}
public class AfterClass {

	public static void main(String[] args) {
		new Cal();
	}

}
