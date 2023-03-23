package days16;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JCheckBoxText extends JFrame implements ItemListener{
	JTextField jtf;
	JCheckBox jcb1;
	JCheckBox jcb2;
	JCheckBox jcb3;
	JCheckBox jcb4;
	
	JCheckBoxText(){
		jcb1 = new JCheckBox("JSP");
		jcb2 = new JCheckBox("PHP");
		jcb3 = new JCheckBox("ASP");
		jcb4 = new JCheckBox("SEREVLET");
		jtf= new JTextField(30);
		Font f = new Font("굴림", Font.BOLD, 20);
		jcb1.setFont(f);
		jcb2.setFont(f);
		jcb3.setFont(f);
		jcb4.setFont(f);
		jtf.setFont(f);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jcb1);
		con.add(jcb2);
		con.add(jcb3);
		con.add(jcb4);
		con.add(jtf);
		
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		jcb4.addItemListener(this);
		
		setTitle("CheckBox Practice");
		setSize(800,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		String s = "";
		if(jcb1.isSelected()) s=s+"JSP ";
		if(jcb2.isSelected()) s=s+"PHP ";
		if(jcb3.isSelected()) s=s+"ASP ";
		if(jcb4.isSelected()) s=s+"SEREVLET ";
				
		jtf.setText("Selected box : "+s);
		
		
	}
}
public class Swing16 {

	public static void main(String[] args) {

		new JCheckBoxText();
	}

}
