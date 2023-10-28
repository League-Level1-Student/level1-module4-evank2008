package _06_calculator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class Calculator implements ActionListener{

	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton div = new JButton();
	JButton mul = new JButton();
	JTextField input1 = new JTextField(9);
	JTextField input2 = new JTextField(9);
		JLabel output = new JLabel();
	public void run() {
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(300,450));
		
		panel.add(input1);
		panel.add(input2);
		
		add.addActionListener(this);
		sub.addActionListener(this);
		div.addActionListener(this);
		mul.addActionListener(this);
		add.setPreferredSize(new Dimension(120,120));
		sub.setPreferredSize(new Dimension(120,120));
		div.setPreferredSize(new Dimension(120,120));
		mul.setPreferredSize(new Dimension(120,120));
		add.setText("+");
		sub.setText("-");
		div.setText("÷");
		mul.setText("×");
		panel.add(add);
		panel.add(sub);
		panel.add(div);
		panel.add(mul);
		frame.setTitle("Calculator(no decimals pls)");
		output.setText("");
		output.setPreferredSize(new Dimension(250,120));
		output.setSize(250,120);
		output.setFont(new Font("Arial", 0, 40));
		panel.add(output);
		
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(input1.getText());
		int num2 = Integer.parseInt(input2.getText());
		double opNum=0;
		
		if(e.getSource()==add) {
			opNum = num1+num2;
			output.setText(num1+"+"+num2+"="+opNum);
			frame.pack();
		}
		else if(e.getSource()==sub) {
			opNum = num1-num2;
			output.setText(num1+"-"+num2+"="+opNum);
			frame.pack();
		}
		else if(e.getSource()==div) {
			if(num2==0) {
				output.setText("nuh uh");
				frame.pack();
			}
			else {
			opNum = num1/num2;
			output.setText(num1+"÷"+num2+"="+opNum);
			frame.pack();
			}
		}
		else if(e.getSource()==mul) {
			opNum = num1*num2;
			output.setText(num1+"×"+num2+"="+opNum);
			frame.pack();
		}
	}
}
