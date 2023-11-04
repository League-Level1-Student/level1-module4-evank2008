package _09_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener{
	 JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		JButton b1 = new JButton("mole!");
		int holes;
		
	
	
	public static void main(String[] args) {
		new WhackAMole();
	
	}
	public WhackAMole() {
		
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("whack a mole");
		
		

		holes = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Whack-A-Mole!\nHow many holes for the mole?"));
		drawButtons(holes);
	}
void drawButtons(int countn) {
	int count = Math.abs(countn);
	if(count%4==0) {
	panel.setPreferredSize(new Dimension(375,count*9));
	}
	else {
		panel.setPreferredSize(new Dimension(375,(count+4)*9));
	}
	Random ran = new Random();
	int chosen = ran.nextInt(count)+1;
	for(int i = count;i>0;i--) {
	
		if(i==chosen) {
			b1=new JButton("mole!");
			b1.addActionListener(this);
			panel.add(b1);
		}
		else {
			panel.add(new JButton("hole!"));
		}
		
	}
frame.setVisible(true);
frame.pack();
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.remove(panel);
		panel = new JPanel();
		frame.add(panel);
		holes++;
		drawButtons(holes);
		
	}
}
