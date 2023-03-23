package days16;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class JRadioButtonTest extends JFrame implements ActionListener{
	JTextField jtf;
	JRadioButton jcb1;
	JRadioButton jcb2;
	JRadioButton jcb3;
	JRadioButton jcb4;
	ButtonGroup bg;
	
	JRadioButtonTest(){
		jcb1 = new JRadioButton("승마");
		jcb2 = new JRadioButton("골프");
		jcb3 = new JRadioButton("글라이딩");
		jcb4 = new JRadioButton("스쿠버");
		jtf= new JTextField(30);
		Font f = new Font("굴림", Font.BOLD, 20);
		jcb1.setFont(f);
		jcb2.setFont(f);
		jcb3.setFont(f);
		jcb4.setFont(f);
		jtf.setFont(f);
		
		bg= new ButtonGroup(); //이걸 해줘야 한개씩만 선택됨
		bg.add(jcb1); bg.add(jcb2); bg.add(jcb3); bg.add(jcb4);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jcb1);
		con.add(jcb2);
		con.add(jcb3);
		con.add(jcb4);
		con.add(jtf);
		
		jcb1.addActionListener(this);
		jcb2.addActionListener(this);
		jcb3.addActionListener(this);
		jcb4.addActionListener(this);
		
		setTitle("Radio Button Practice");
		setSize(800,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(jcb1.isSelected()) jtf.setText(jcb1.getActionCommand()+" is selected.");
		else if(jcb2.isSelected()) jtf.setText(jcb2.getActionCommand()+" is selected.");
		else if(jcb3.isSelected()) jtf.setText(jcb3.getActionCommand()+" is selected.");
		else  jtf.setText(jcb4.getActionCommand()+" is selected.");
	}

}
public class Swing17 {

	public static void main(String[] args) {

		new JRadioButtonTest();
	}

}
