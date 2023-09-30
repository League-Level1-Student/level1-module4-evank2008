package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleCicker implements ActionListener {
	JButton b1 = new JButton();
	JButton b2 = new JButton();
public static void main(String[] args) {
	ChuckleCicker cc = new ChuckleCicker();
	cc.makeButtons();
}
void makeButtons() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel panel = new JPanel();
	frame.add(panel);
	
	panel.add(b1);
	panel.add(b2);
	b1.setText("joke");
	b2.setText("punchline");
	frame.setVisible(true);
	frame.pack();
	
	b1.addActionListener(this);
	b2.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {

	
	if(e.getSource()==b1) {
		JOptionPane.showMessageDialog(null, "Why do you never see an elephant hiding in a cherry tree?");
	}
if(e.getSource()==b2) {
	JOptionPane.showMessageDialog(null, "Because it is a very stealthy elephant!");
}
	
	
}
}
