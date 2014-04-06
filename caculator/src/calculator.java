
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calculator extends JFrame {
	
	private JTextField jtfResult = new JTextField();
	private JButton jbt[];
	private double sol = 0;
	private String now_num = "";
	private double temp = 0;
	private int option = 0;
	private boolean reset = false;
	public calculator(){
		jtfResult = new JTextField("0");
		jtfResult.setEditable(false);
		jtfResult.setBackground(Color.WHITE);
		JPanel p1 = new JPanel(new GridLayout(1,1) );
		p1.add(jtfResult,BorderLayout.NORTH);
		jbt = new JButton[25];
		
		JPanel p2 = new JPanel(new GridLayout(5,3) );
		for (int i = 0; i <= 9; i++){
			jbt[i] = new JButton(i + "");
			jbt[i].addActionListener(new ButtonListener());
		}
		jbt[12] = new JButton("C");
		jbt[12].addActionListener(new ButtonListener());
		jbt[12].setForeground(Color.RED);
		p2.add(jbt[12]);
		jbt[13] = new JButton("x√");
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
			if(e.getSource() == jbt[0] || e.getSource() == jbt[1] || e.getSource() == jbt[2] ||
				e.getSource() == jbt[3] || e.getSource() == jbt[4] || e.getSource() == jbt[5]
				|| e.getSource() == jbt[6] || e.getSource() == jbt[7] || e.getSource() == jbt[8]
				|| e.getSource() == jbt[9]){
				now_num = jtfResult.getText();
				if(reset){
				reset = false;
				jtfResult.setText(e.getActionCommand());
				}
				else{
					now_num=jtfResult.getText();
                    jtfResult.setText(now_num+e.getActionCommand());
				}
			}
			else if(e.getSource() == jbt[11]){
				double now = Math.PI;
				jtfResult.setText(String.format("%.12f", now));
			}
			else if(e.getSource() == jbt[10]){
				now_num = jtfResult.getText();
				jtfResult.setText(now_num+ ".");
			}
			else if(e.getSource()==jbt[19]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 1;
					reset = true;
				}
				else{
					temp = now;
					option = 1;
					sol = operation(option,sol,temp);
					reset = true;
				}
				jtfResult.setText(sol +"");
			}
			else if(e.getSource() == jbt[20]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 2;
					reset = true;
				}
				else{
					temp = now;
					option = 2;
					sol = operation(option, sol, temp);
					reset = true;
				}
				jtfResult.setText(sol+"");
			}
			else if (e.getSource() == jbt[21]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 3;
					reset = true;
				}
				else{
					temp = now;
					option = 3;
					sol = operation(option,sol,temp);
					reset = true;
				}
				jtfResult.setText(sol + "");
			}
			else if(e.getSource() == jbt[22]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 4;
					reset = true;
				}
				else{
					temp = now;
					option =4;
					sol = operation(option,sol,temp);
					reset = true;
				}
			}
			else if(e.getSource() == jbt[15]){
				double now = Double.parseDouble(jtfResult.getText());
				temp = now;
				option = 5;
				sol = operation(option,sol,temp);
				reset = true;
			}
			else if(e.getSource() == jbt[16]){
				double now = Double.parseDouble(jtfResult.getText());
				temp = now;
				option = 6 ;
				sol = operation(option, sol, temp);
				reset = true;
			}
			else if(e.getSource() == jbt[17]){
				double now = Double.parseDouble(jtfResult.getText());
				temp = now;
				option = 7;
				sol = operation(option, sol, temp);
				reset = true;
			}
			
			// =
			else if(e.getSource() == jbt[24]){
				double now = Double.parseDouble(jtfResult.getText());
				temp = now;
				sol = operation(option,sol,temp);
				option = 0;
				reset = true;
				jtfResult.setText(sol+ "");
			}
			else if(e.getSource() == jbt[18]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 8;
					reset = true;
				}
				else{
					temp = now;
					option = 8;
					sol = operation(option, sol, temp);
					reset = true;
				}
			}
			else if(e.getSource() == jbt[12]){
				temp = 0;
				sol = 0;
				option = 0;
				reset = true;
				jtfResult.setText("0");
			}
			else if(e.getSource() == jbt[13]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 10;
					reset = true;
				}
				else{
					temp = now;
					option = 10;
					sol = operation(option, sol, temp);
					reset = true;
				}
			}
			else if(e.getSource() == jbt[14]){
				double now = Double.parseDouble(jtfResult.getText());
				if(option == 0){
					sol = now;
					option = 9;
					reset = true;
				}
				else{
					temp = now;
					option = 9;
					sol = operation(option,sol,temp);
					reset = true;
				}
			}
			}
			
	
		
	public double operation(int option, double sol,double temp){
		if(option == 1){
			sol = sol + temp;
		}
		else if(option ==2){
			sol = sol - temp;
		}
		else if(option ==3){
			sol = sol * temp;
		}
		else if(option == 4){
			sol = sol/ temp;
		}
		else if(option ==5){
			sol = Math.sin(temp);
		}
		else if(option == 6){
			sol = Math.cos(temp);
		}
		else if(option == 7){
			sol = Math.tan(temp);
		}
		else if(option == 8){
			sol = Math.pow(sol,temp);
		}
		else if(option == 9){
			sol = Math.log10(temp);
		}
		else if(option == 10){
			sol = Math.pow(sol, 1/temp);
		}
		return sol;
	}
	}

	public static void main(String[] args){
		calculator c = new calculator();
		c.setTitle("Calculator");
		c.setSize(500,400);
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}
}


