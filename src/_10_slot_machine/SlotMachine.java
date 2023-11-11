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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SlotMachine implements ActionListener{
	boolean ownerMode = true;
		int netWorth = 5000;
		double machineMoney = 0;
		int counter = 0;
		String whatIs1 = null;
		String whatIs2 = null;
		String whatIs3 = null;
		JPanel panelMain = new JPanel();
		JPanel panelTop = new JPanel();
		JPanel panelLow = new JPanel();
		JFrame frame = new JFrame();
		JButton depositButton = new JButton();
		JButton playButton = new JButton();
		JButton leave = new JButton("cash out");
		JLabel s1 = new JLabel();
		JLabel s2 = new JLabel();
		JLabel s3 = new JLabel();
		JLabel balText = new JLabel();
		JLabel machineBalText = new JLabel();
		Random ran = new Random();
		Timer timer = new Timer(200,this);
		JLabel bb = createLabelImage("bbDorto.jpg");
		JLabel col = createLabelImage("colDorto.jpg");
		JLabel fake = createLabelImage("fakedorto.jpg");
		JLabel spicy = createLabelImage("spicydorto.jpg");
		JLabel stinky = createLabelImage("stinkyDorto.jpg");
	public static void main(String[] args) {
		
		new SlotMachine();
		
	}
	SlotMachine() {
		frame.add(panelMain);
		panelMain.add(panelTop);
		panelMain.add(panelLow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 
		s1=createLabelImage("colDorto.jpg");
		s2=createLabelImage("bbDorto.jpg");
		s3=createLabelImage("stinkyDorto.jpg");
		
		panelTop.add(s1);
		panelTop.add(s2);
		panelTop.add(s3);
		
		depositButton.setPreferredSize(new Dimension(150,150));
		playButton.setPreferredSize(new Dimension(150,150));

		depositButton.setText("Deposit $86");
		playButton.setText("Spin! $100");
		
		balText.setText("Current Bank Account: $" + netWorth);
		machineBalText.setText(" \n YOUR BALANCE: $" + machineMoney);
		
		panelTop.add(leave);
		panelLow.add(balText);
		panelLow.add(machineBalText);
		panelLow.add(depositButton);
		panelLow.add(playButton);
		
		
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
		if(e.getSource()==playButton) {
			try {
				Spin();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==depositButton) {
			if(netWorth>=86) {
				netWorth -= 86;
				machineMoney += 86;
				
				Update();
			}
		}
		else if(e.getSource()==timer) {
			
			counter ++;
			
			panelTop.remove(leave);
			

			
			panelTop.remove(s1);
			panelTop.remove(s2);
			panelTop.remove(s3);
			switch (ran.nextInt(5)) {
			case 0: 
				s1=bb;
				break;
			case 1:
				s1=col;
				break;
			case 2:
				s1=stinky;
				break;
			case 3:
				s1=spicy;
				break;
			case 4:
				s1=fake;
				break;
			}
			switch (ran.nextInt(5)) {
			case 0: 
				s2=bb;
				break;
			case 1:
				s2=col;
				break;
			case 2:
				s2=stinky;
				break;
			case 3:
				s2=spicy;
				break;
			case 4:
				s2=fake;
				break;
			}
			switch (ran.nextInt(5)) {
			case 0: 
				s3=bb;
				break;
			case 1:
				s3=col;
				break;
			case 2:
				s3=stinky;
				break;
			case 3:
				s3=spicy;
				break;
			case 4:
				s3=fake;
				break;
			}
			panelTop.add(s1);
			panelTop.add(s2);
			panelTop.add(s3);
			panelTop.add(leave);
			frame.pack();
			
			panelTop.repaint();
			
			if(counter==15) {
				timer.stop();
				counter=0;
			}
		}
	}
	void Update() {
		balText.setText("Current Bank Account: $" + netWorth);
		machineBalText.setText(" \n YOUR BALANCE: $" + machineMoney);
		
		frame.pack();
	}
	void Spin() throws MalformedURLException {
		if(machineMoney<100&&ownerMode==false) {
			JOptionPane.showMessageDialog(null,"ERROR. NOT ENOUGH CREDITS.");
		}
		else {
			if(ownerMode==false) {
			machineMoney -= 100;
			}
			timer.start();
		Update();
		}
	}
	 JLabel createLabelImage(String fileName){
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

