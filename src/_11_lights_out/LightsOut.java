package _11_lights_out;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 * Lights Out is a puzzle game with a grid of lights that are either on (light
 * gray) or off (white). Pressing any light will toggle it and its adjacent
 * lights. The goal of the game is to switch all the lights off.
 * 
 * Follow the instructions below to create your own version of Lights Out
 * 
 * 
 */
public class LightsOut implements MouseListener {
	int winCount = 0;
boolean win = false;
	JPanel gamePanel = new JPanel();
	JFrame gameFrame = new JFrame();
	public LightsOut() {

		/** PART 1. CREATE YOUR LIGHT BOARD **/
		//1. Make your gamePanel a 5x5 grid with setLayout(new GridLayout(5, 5));
		
		gamePanel.setLayout(new GridLayout(5,5));
			//2. Add 25 JLabels to your gamePanel (these are your lights)
		for(int i = 0;i<25;i++) {
			JLabel label = new JLabel();
			label.setText(""+i);
			label.setForeground(Color.LIGHT_GRAY);
			label.setBackground(Color.LIGHT_GRAY);
			label.setOpaque(true);
			label.addMouseListener(this);
			label.setPreferredSize(new Dimension(150,150));
			label.setBorder(new LineBorder(Color.black, 7));
			gamePanel.add(label);
		}
			//3. Use setText() to add a position number to each light (0-24).

			//4. Set the background of each light to LIGHT_GRAY
			// - you will also have to set the background to opaque.
			// - Use light.setOpaque(true);

			//5. Add a mouseListener to each light
		gameFrame.add(gamePanel);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//6. Add your panel to a frame
		gameFrame.pack();
	//	gameFrame.setSize(new Dimension(750,750));
		//7. Set the size of the frame

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/** PART 2: TOGGLE NEIGHBORING LIGHTS **/
		// 1. Get the light that was clicked on `(JLabel) e.getSource`
		JLabel labell = (JLabel)e.getSource();
		// 2. Get the number (position) of the light
		System.out.println(labell.getText());
		makeMove(Integer.parseInt(labell.getText()));
		gameFrame.pack();
		// 3. Now use the makeMove method to code which lights turn on and off.

		// 4.Check if the player has won (e.g. all the lights are off)
		// ---- HINT: use `getLightAtPosition` to get the light at each position
		// ---------- use 'getBackground' to get the light color\
		winCount = 0;
for(int i = 0;i<25;i++) {
	if(getLightAtPosition(i).getBackground()==Color.LIGHT_GRAY) {
	winCount = 1;
	}
}
if(winCount == 0) {
	JOptionPane.showMessageDialog(null, "YOU WIN");
	System.exit(0);
}
		/** PART 3: RANDOMIZE YOUR BOARD **/
		// Now that your game works can you make the game start with some lights on?

	}

	void makeMove(int pos) {
		toggle((JLabel) gamePanel.getComponent(pos));
		if (pos >= 5) {
			toggle((JLabel) gamePanel.getComponent(pos - 5));
		}
		if ((pos + 1) % 5 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos + 1));
		}
		if (pos % 5 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos - 1));
		}
		if (pos + 5 <= 24) {
			toggle((JLabel) gamePanel.getComponent(pos + 5));
		}
	}

	JLabel getLightAtPosition(int lightPosition) {
		return (JLabel) gamePanel.getComponent(lightPosition);
	}

	void toggle(JLabel label) {
		if (label.getBackground() == Color.LIGHT_GRAY) {
			label.setBackground(Color.WHITE);
			label.setForeground(Color.WHITE);
		} else {
			label.setBackground(Color.LIGHT_GRAY);
			label.setForeground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
