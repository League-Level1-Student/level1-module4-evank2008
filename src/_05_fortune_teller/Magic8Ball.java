package _05_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below
public static void main(String[] args) {
	

	// 2. Get the user to enter a question for the 8 ball to answer
	JOptionPane.showMessageDialog(null,"Think of a question and   The Fortune Teller   will answer it.");

	// 3. Make a variable and initialize it to a random number.
	//     ** You will need to make a random object!
	//     Limit the random numbers to be between 0 and 3
	Random ran = new Random();
	int num = ran.nextInt(4);

	// 4. If the random number is 0
	switch(num) {
	case 0:
		JOptionPane.showMessageDialog(null,"furtune teller say: of course ya");
		break;
	case 1:
		JOptionPane.showMessageDialog(null,"furtune teller say: hAYell nah");
		break;
	case 2:
		JOptionPane.showMessageDialog(null,"furtune teller say: ask the Google how should I know that?");
		break;
	default:
	case 3:
		JOptionPane.showMessageDialog(null,"furtune teller say: error code 3x8923729836509." + "\n good luck finding any info on fixing this hahaha");
		break;
	
	}
	// -- tell the user "Yes"

	// 5. If the random number is 1

	// -- tell the user "No"

	// 6. If the random number is 2

	// -- tell the user "Maybe you should ask Google?"

	// 7. If the random number is 3

	// -- write your own answer
	}
}