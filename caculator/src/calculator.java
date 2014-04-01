
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calculator extends JFrame {
	private JTextField jtfResult = new JTextField();
	private JButton jbt[];
	
	public calculator(){
		jtfResult = new JTextField();
		jtfResult.setEditable(false);
		jtfResult.setBackground(Color.WHITE);
		JPanel p1 = new JPanel(new GridLayout(1,1) );
		p1.add(jtfResult);
		jbt = new JButton[27];
		
		JPanel p2 = new JPanel(new GridLayout(5,3) );
		for (int i = 0; i <= 9; i++){
			jbt[i] = new JButton(i + "");
			jbt[i].addActionListener(new ButtonListener());
		}
		p2.add(jbt[7]);
		p2.add(jbt[8]);
		p2.add(jbt[9]);
		p2.add(jbt[4]);
		p2.add(jbt[5]);
		p2.add(jbt[6]);
		p2.add(jbt[1]);
		p2.add(jbt[2]);
		p2.add(jbt[3]);
		p2.add(jbt[0]);
		jbt[10] = new JButton(".");
		jbt[10].addActionListener(new ButtonListener());
		p2.add(jbt[10]);
		jbt[11] = new JButton("π");
		jbt[11].addActionListener(new ButtonListener());
		p2.add(jbt[11]);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
	}
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
		}
		
	}
	
	public static  void main(String[] args){
		calculator c = new calculator();
		c.setTitle("Calculator");
		c.setSize(400,300);
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
		
	}
}


