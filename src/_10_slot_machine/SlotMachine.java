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
	boolean ownerMode = false;
	int netWorth = 600;
	int machineMoney = 0;
	int counter = 0;
	int debt = 0;
	String whatIs1 = null;
	String whatIs2 = null;
	String whatIs3 = null;
	JPanel panelMain = new JPanel();
	JPanel panelTop = new JPanel();
	JPanel panelLow = new JPanel();
	JFrame frame = new JFrame();
	JButton loanButton = new JButton();
	JButton payOff = new JButton();
	JButton depositButton = new JButton();
	JButton playButton = new JButton();
	JButton leave = new JButton("cash out");
	JLabel s1 = new JLabel();
	JLabel s2 = new JLabel();
	JLabel s3 = new JLabel();
	JLabel debtText = new JLabel();
	JLabel balText = new JLabel();
	JLabel machineBalText = new JLabel();
	Random ran = new Random();
	Timer timer = new Timer(100,this);
	Timer timer2 = new Timer(1100, this);
	Icon bb = createIcon("bbDorto.jpg");
	Icon col = createIcon("colDorto.jpg");
	Icon fake = createIcon("fakedorto.jpg");
	Icon spicy = createIcon("spicydorto.jpg");
	Icon stinky = createIcon("stinkyDorto.jpg");
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
		loanButton.setPreferredSize(new Dimension(150,150));
		payOff.setPreferredSize(new Dimension(150,150));

		depositButton.setText("Deposit $86");
		playButton.setText("Spin! $100");
		loanButton.setText("Get a loan. $201");
		payOff.setText("Pay debts");

		balText.setText("Current Bank Account: $" + netWorth);
		machineBalText.setText(" \n YOUR BALANCE: $" + machineMoney);
		//debtText.setText("debt go here");

		panelTop.add(leave);
		panelLow.add(debtText);
		panelLow.add(balText);
		panelLow.add(machineBalText);
		panelLow.add(payOff);
		panelLow.add(loanButton);
		panelLow.add(depositButton);
		panelLow.add(playButton);


		frame.setTitle("FreeMoneyNoSkillRequired.real");
		frame.setPreferredSize(new Dimension(1920,900));

		payOff.addActionListener(this);
		loanButton.addActionListener(this);
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
else if (e.getSource()==loanButton) {
			debt+=201;
			netWorth+=201;
			Update();
		}
else if (e.getSource()==payOff) {
	if(debt==0) {
		JOptionPane.showMessageDialog(null, "You aren't in any debt! Lucky.");
	}
	else if(machineMoney==0) {
		JOptionPane.showMessageDialog(null, "You don't have any money to pay off your debts with!");
	}
	else {
		if(machineMoney>=debt) {
			machineMoney-=debt;
			debt-=debt;
		}
		else {
			debt-=machineMoney;
			machineMoney-=machineMoney;
		}
	}
	Update();
}
		else if (e.getSource()==leave) {
			int newNetWorth = machineMoney+netWorth-debt;
			if(newNetWorth<0) {
			JOptionPane.showMessageDialog(null, "You finally got away from this wretched machine. \n You've sunk all your life savings into it and more. \n What did you get in return? Inescapable debt. \n The bank forecloses on your ass and you are forced to \n live the rest of your life assless; a sad, \n soulless existence. You curse whatever devil created \n this heartless box in the first place as the \n ass collectors pry your ass off.");
			JOptionPane.showMessageDialog(null, "ASSLESS ENDING");
			System.exit(0);
			}
			else if(newNetWorth==0) {
				JOptionPane.showMessageDialog(null, "By some miracle, you saved yourself from falling into inescapable debt. \n Sadly, you are now flat broke. Like, you have exactly no money left. /n How this happened is unclear. You are forced to live out the rest of your life as \n a homeless man. Thankfully, your ass is untouched.");
			JOptionPane.showMessageDialog(null, "BROKE ENDING");
			System.exit(0);
			}
			else if(newNetWorth<600) {
				JOptionPane.showMessageDialog(null, "You walk away from the machine, with noticably lighter pockets. \n You lost a lot of money here, for sure. Still, you are able to \n return to some semblance of your old life. \n Thanks for playing.");
				JOptionPane.showMessageDialog(null, "CHILL ENDING");
				System.exit(0);
			}
			else if(newNetWorth==600) {
				JOptionPane.showMessageDialog(null,"You leave the slot machine without playing. \n Unchanged, you wonder what might have happened \n had you decided to play. Oh well.");
				JOptionPane.showMessageDialog(null, "BORED ENDING");
				System.exit(0);
			}
			else if(newNetWorth>600&&newNetWorth<1000) {
				JOptionPane.showMessageDialog(null, "You managed to make some money from that slot machine! \n I guess gambling isn't so bad after all. \n On the way home, you treat yourself to a bag of M&Ms \n from the casino's vending machine.");
				JOptionPane.showMessageDialog(null,"CHOCOLATE ENDING");
				System.exit(0);
			}
			else if(newNetWorth>=1000) {
				JOptionPane.showMessageDialog(null,"Incredible! You managed to earn over $1,000 from that slot machine! \n Now you can afford that new 2025 iPhoneCharger they released last year.");
				JOptionPane.showMessageDialog(null, "CHARGER ENDING");
				System.exit(0);
			}
			else {
				System.exit(0);
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
				s1.setIcon(bb);
				break;
			case 1:
				s1.setIcon(col);
				break;
			case 2:
				s1.setIcon(stinky);
				break;
			case 3:
				s1.setIcon(spicy);
				break;
			case 4:
				s1.setIcon(fake);	
				break;
			}
			switch (ran.nextInt(5)) {
			case 0: 
				s2.setIcon(bb);
				break;
			case 1:
				s2.setIcon(col);
				break;
			case 2:
				s2.setIcon(stinky);
				break;
			case 3:
				s2.setIcon(spicy);
				break;
			case 4:
				s2.setIcon(fake);	
				break;
			}
			switch (ran.nextInt(5)) {
			case 0: 
				s3.setIcon(bb);
				break;
			case 1:
				s3.setIcon(col);
				break;
			case 2:
				s3.setIcon(stinky);
				break;
			case 3:
				s3.setIcon(spicy);
				break;
			case 4:
				s3.setIcon(fake);	
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
				timer2.start();

			}
		}
		else if (e.getSource()==timer2) {
			int winnings = 0;
			timer2.stop();
			if(s1.getIcon()==s2.getIcon()) {
				if(s1.getIcon()==col) {
					winnings = 198;
				}
				if(s1.getIcon()==bb) {
					winnings = 101;
				}
				if(s1.getIcon()==spicy) {
					winnings = 50;
				}
				if(s1.getIcon()==stinky) {
					winnings = 25;
				}
				if(s1.getIcon()==fake) {
					winnings = 1;
				}
				machineMoney+=winnings;
				Update();
			JOptionPane.showMessageDialog(null, "DING DING! \n You win: $" + winnings);
			}
			if(s1.getIcon()==s2.getIcon()&&s2.getIcon()==s3.getIcon()) {
				if(s1.getIcon()==col) {
					winnings = 999;
				}
				if(s1.getIcon()==bb) {
					winnings = 500;
				}
				if(s1.getIcon()==spicy) {
					winnings = 284;
				}
				if(s1.getIcon()==stinky) {
					winnings = 100;
				}
				if(s1.getIcon()==fake) {
					winnings = 95;
				}
				machineMoney+=winnings;
				Update();
				JOptionPane.showMessageDialog(null, "POGGERS! YOU HIT THE JACKPOT! \n You win: $" + winnings);
			}
			
		}
	}
	void Update() {
		balText.setText("Current Bank Account: $" + netWorth);
		machineBalText.setText(" \n YOUR BALANCE: $" + machineMoney);
		if(debt>0) {
			debtText.setText("You are $" + debt + " in debt.");
		}
		else {
			debtText.setText("");
		}
		frame.pack();
		if(machineMoney+netWorth-debt<-1000) {
			JOptionPane.showMessageDialog(null, "You never figured it would happen like this. \n Playing this slot machine, taking out loans. You were unaware \n that you were over $1,000 in debt. While entranced by the flashing lights, \n the casino manager sleathily appeared behind you. He \n shot you in the back of the head and you died.");
		JOptionPane.showMessageDialog(null, "YOU LITERALLY GET SHOT IN THE BACK OF THE HEAD ENDING");
		System.exit(0);
		}
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
	Icon createIcon(String fileName){
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return icon;
	}



}

