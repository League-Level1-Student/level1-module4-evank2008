package _02_jeopardy;


/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;


/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	int lastQuestion = 0;
	int lastlast = 0;
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private Sound jeopardyThemeClip;



	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("Djepaeuxrdeigh");
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel header = new JPanel();
		// 4. Add the header component to the quizPanel
		quizPanel.add(header);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton(100);
		quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.

		// 9. Use the secondButton variable to hold a button using the createButton
		// method
		secondButton = createButton(200);
		quizPanel.add(secondButton);
		// 10. Add the secondButton to the quizPanel

		// 11. Add action listeners to the buttons (2 lines of code)

		// 12. Write the code to complete the actionPerformed() method below

		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
		thirdButton = createButton(400);
		quizPanel.add(thirdButton);
		fourthButton = createButton(937);
		quizPanel.add(fourthButton);
		/*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */

		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}


	private JButton createButton(int dollarAmount) {

		// Create a new JButton
		JButton jbut = new JButton();
		// Set the text of the button to the dollarAmount
		jbut.setText("$"+dollarAmount);
		jbut.addActionListener(this);
		// Increment the buttonCount (this should make the layout vertical)
		// Return your new button instead of the temporary button

		return jbut;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
		if(buttonPressed==firstButton) {
			if(lastQuestion==1) {
				stopJeopardyTheme();
				JOptionPane.showMessageDialog(null, "You can't answer the same question twice in a row!");
			}
			else {
				lastlast=lastQuestion;
				lastQuestion = 1;
				askQuestion("How much wood could a woodchuck chuck if a woodchuck could chuck wood?",
						"Well a woodchuck could chuck as much wood as a woodchuck would chuck if a woodchuck could chuck wood",100);
			}}
		if(buttonPressed==secondButton) {
			if(lastQuestion==2) {
				stopJeopardyTheme();
				JOptionPane.showMessageDialog(null, "You can't answer the same question twice in a row!");
			}
			else {
				lastlast=lastQuestion;
				lastQuestion = 2;
				askQuestion("Convert the standard-form equation to vertex form:\n y=x^2+14x+48","y=(x+7)^2-1",200);	
			}}
		if(buttonPressed==thirdButton) {
			if(lastQuestion==3) {
				stopJeopardyTheme();
				JOptionPane.showMessageDialog(null, "You can't answer the same question twice in a row!");
			}
			else {
				lastlast=lastQuestion;
				lastQuestion = 3;
			askQuestion("Is the answer to this question not a truthful lie? yes/no only","yes",400);	
			}}
		if(buttonPressed==fourthButton) {
			if(lastQuestion==4) {
				stopJeopardyTheme();
				JOptionPane.showMessageDialog(null, "You can't answer the same question twice in a row!");
			}
			else {
				lastlast=lastQuestion;
				lastQuestion = 4;
			askQuestion("How many times in a row is the first note of ''Jingle Bells'' repeated?","7",937);
			}}
		// Call the askQuestion() method

		// Complete the code in the askQuestion() method. When you play the game, the score should change.

		// If the buttonPressed was the secondButton

		// Call the askQuestion() method with a harder question

		// Clear the text on the button that was pressed (set the button text to nothing)

	}

	private void askQuestion(String question, String correctAnswer, double prizeMoney) {

		// Use the playJeopardyTheme() method to play music while the use thinks of an answer
		playJeopardyTheme();
		// Remove this temporary message and replace it with a pop-up that asks the user the question
		String answer = JOptionPane.showInputDialog(question);
		if(answer!=null&&answer.equalsIgnoreCase(correctAnswer)) {
			stopJeopardyTheme();
			score+=prizeMoney;
			JOptionPane.showMessageDialog(null, "Correct! You pass Go " + prizeMoney/200 + " times and collect $" + prizeMoney + "!");
		}
		else if (answer==null) {
			stopJeopardyTheme();
			lastQuestion=lastlast;
		}
		else {
			stopJeopardyTheme();
			score-=prizeMoney;
			JOptionPane.showMessageDialog(null, "Wrong! You fall into the pit of despair and lose $" + prizeMoney);
		}
		updateScore();

		// Stop the theme music when they have entered their response.

		// If the answer is correct

		// Increase the score by the prizeMoney

		// Pop up a message to tell the user they were correct

		// Otherwise

		// Decrement the score by the prizeMoney

		// Pop up a message to tell the user they were wrong and give them the correct answer

		// Call the updateScore() method

	}

	public void playJeopardyTheme() {
		String fileName = "_02_jeopardy/jeopardy.wav";
		jeopardyThemeClip = new Sound(fileName);
		jeopardyThemeClip.play();
	}

	public void stopJeopardyTheme() {
		jeopardyThemeClip.stop();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
		if(score<=-1000) {
			JOptionPane.showMessageDialog(null, "You died to debt collector hitmen because of your debts. Game Over.");
			System.exit(0);
		}
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
