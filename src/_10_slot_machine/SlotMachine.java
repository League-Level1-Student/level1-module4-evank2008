package _10_slot_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener{
	  JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		JButton depositButton = new JButton();
		JButton playButton = new JButton();
		JButton leave = new JButton("cash out");
		JLabel s1 = new JLabel();
		JLabel s2 = new JLabel();
		JLabel s3 = new JLabel();
	
	public static void main(String[] args) {
		
		new SlotMachine();
		
	}
	SlotMachine() {
		Random ran = new Random();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 
		try {
			s1=createLabelImage("colDorto.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		depositButton.setPreferredSize(new Dimension(150,150));
		playButton.setPreferredSize(new Dimension(150,150));

		depositButton.setText("Deposit $86");
		playButton.setText("Spin! $100");
		
		panel.add(leave);
		panel.add(depositButton);
		panel.add(playButton);
		
		frame.setTitle("FreeMoneyNoSkillRequired.real");
		frame.setPreferredSize(new Dimension(2048,900));
		
		depositButton.addActionListener(this);
		playButton.addActionListener(this);
		leave.addActionListener(this);
		
		
		
		frame.pack();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}



}

