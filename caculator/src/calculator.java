
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
		jbt = new JButton[25];
		
		JPanel p2 = new JPanel(new GridLayout(5,3) );
		for (int i = 0; i <= 9; i++){
			jbt[i] = new JButton(i + "");
			jbt[i].addActionListener(new ButtonListener());
		}
		jbt[12] = new JButton("print");
		jbt[12].addActionListener(new ButtonListener());
		jbt[12].setForeground(Color.RED);
		p2.add(jbt[12]);
		jbt[13] = new JButton("C");
		jbt[13].addActionListener(new ButtonListener());
		jbt[13].setForeground(Color.RED);
		p2.add(jbt[13]);
		jbt[14] = new JButton("log");
		jbt[14].addActionListener(new ButtonListener());
		p2.add(jbt[14]);
		jbt[14].setForeground(Color.RED);
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
		JPanel p3 = new JPanel(new GridLayout(5,2));
		jbt[15] = new JButton("sin");
		jbt[16] = new JButton("cos");
		jbt[17] = new JButton("tan");
		jbt[18] = new JButton("^");
		jbt[19] = new JButton("+");
		jbt[20] = new JButton("-");
		jbt[21] = new JButton("×");
		jbt[22] = new JButton("÷");
		jbt[23] = new JButton("±");
		jbt[24] = new JButton("=");
		for(int i = 15; i <= 24; i++){
			p3.add(jbt[i]);
			jbt[i].setForeground(Color.RED);
			jbt[i].addActionListener(new ButtonListener());
		}
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.EAST);
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


