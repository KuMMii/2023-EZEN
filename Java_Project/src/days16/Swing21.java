package days16;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Resume extends JFrame implements ActionListener{
	JTextField jtName;
	
	JRadioButton jr1;
	JRadioButton jr2;
	ButtonGroup bg;
	
	JCheckBox jc1;
	JCheckBox jc2;
	JCheckBox jc3;
	JCheckBox jc4;
	
	JComboBox<String> jcb1;
	JTextField jtPhone2;
	JTextField jtPhone3;
	
	JComboBox<String> jcb2;
	
	JButton b1;
	
	String address;
	String number;
	String hobby;
	String sex;
	String name;
	
	
	Resume(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		Font f = new Font("굴림", Font.BOLD,15);
		p1.setLayout(new GridLayout(6,1));
		JLabel l1= new JLabel("성      명:");
		JLabel l2= new JLabel("성      별:");
		JLabel l3= new JLabel("취      미:");
		JLabel l4= new JLabel("전화번호:");
		JLabel l5= new JLabel("거주지역:");
		l1.setFont(f); l2.setFont(f); l3.setFont(f); l4.setFont(f); l5.setFont(f);
		p1.add(l1); p1.add(l2); p1.add(l3); p1.add(l4); p1.add(l5);
		con.add(p1,  BorderLayout.WEST);
		
		
		
		p2.setLayout(new GridLayout(6,1));
		
		JPanel p21 = new JPanel();
		JPanel p22 = new JPanel();
		JPanel p23 = new JPanel();
		JPanel p24 = new JPanel();
		JPanel p25 = new JPanel();
		JPanel p26 = new JPanel();
		p21.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		p22.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		p23.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		p24.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		p25.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		
		jtName = new JTextField(20);
		p21.add(jtName);
		p2.add(p21);
		
		jr1 = new JRadioButton("남성");
		jr2 = new JRadioButton("여성");
		bg= new ButtonGroup();
		bg.add(jr1); bg.add(jr2);
		p22.add(jr1); p22.add(jr2);
		p2.add(p22);
		
		jc1= new JCheckBox("스포츠");
		jc2= new JCheckBox("영화");
		jc3= new JCheckBox("독서");
		jc4= new JCheckBox("기타");
		p23.add(jc1); p23.add(jc2); p23.add(jc3); p23.add(jc4);
		p2.add(p23);
		
		jcb1 = new JComboBox<String>();
		jcb1.addItem("010");
		jcb1.addItem("02");
		jcb1.addItem("011");
		jcb1.addItem("012");
		JLabel pl1 = new JLabel("-");
		JLabel pl2 = new JLabel("-");
		jtPhone2 = new JTextField(10);
		jtPhone3 = new JTextField(10);
		p24.add(jcb1); p24.add(pl1); p24.add(jtPhone2);  p24.add(pl2); p24.add(jtPhone3); 
		p2.add(p24);
		
		jcb2= new JComboBox<String>();
		jcb2.addItem("서울");
		jcb2.addItem("경기도");
		jcb2.addItem("인천");
		jcb2.addItem("충청도");
		p25.add(jcb2);
		p2.add(p25);
		
		b1 = new JButton("확인");
		p26.add(b1);
		p2.add(p26);
		
		
		
//		p2.add(jc1); p2.add(jc2); p2.add(jc3); p2.add(jc4);
//		p2.setLayout(getLayout());
		con.add(p2, BorderLayout.CENTER);
		
		b1.addActionListener(this);
		
		
		
		setTitle("Resume");
		setSize(640, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		name = jtName.getText();
		
		sex="";
		if(jr1.isSelected()) sex=jr1.getText()+"";
		else if(jr2.isSelected()) sex= jr2.getText()+"";
		
		hobby="";
		if(jc1.isSelected()) hobby= jc1.getText()+"";
		else if(jc2.isSelected()) hobby= jc2.getText()+"";
		else if(jc3.isSelected()) hobby= jc3.getText()+"";
		else hobby= jr2.getText()+"";
		
		number=(String)jcb1.getSelectedItem() +"-"+jtPhone2.getText()+"-"+jtPhone3.getText();
		
		address= (String)jcb2.getSelectedItem();
		
		
		System.out.println("성명 : "+name);
		System.out.println("성별 : "+sex);
		System.out.println("취미 : "+hobby);
		System.out.println("전화번호 : "+number);
		System.out.println("거주지역 : "+address);
//		
//		---------------------------------------------------------------
		//선생님
//		String s;
//		System.out.println("성명 : "+ jtName.getText());
//		if(jr1.isSelected()) s="남성";
//		else s = "여성";
//		System.out.println("성별 : "+s);
//		
//		s="";
//		if(jc1.isSelected())s=s+jc1.getText()+" ";
//		if(jc2.isSelected())s=s+jc2.getText()+" ";
//		if(jc3.isSelected())s=s+jc3.getText()+" ";
//		if(jc4.isSelected())s=s+jc4.getText()+" ";
//		System.out.println("취미 : "+ s);
//		
//		s=(String)jcb1.getSelectedItem() ;
//		s=s+"-"+jtPhone2.getText();
//		s=s+"-"+jtPhone3.getText();
//		
//		System.out.println("전화번호 : " +s);
//		System.out.println("거주지역 : " +jcb2.getSelectedItem());
//		
	}
}
public class Swing21 {

	public static void main(String[] args) {

		new Resume();
	}

}

