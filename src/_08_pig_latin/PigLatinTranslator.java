package _08_pig_latin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {
    JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton tranButton = new JButton();
	JButton swapButton = new JButton();
	JTextField input = new JTextField(9);
	JTextField output = new JTextField(9);
	String textStorage = null;
	/**
     * Method to translate a english to pig latin.
     * 
     * @param s
     *            The sentence in English
     * @return The pig latin version
     */
	public static void main(String[] args) {
		new PigLatinTranslator();
	}
	
	
	public PigLatinTranslator() {
		//the display is made but the actual coding behind the buttons is not.
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.add(input);
		tranButton.addActionListener(this);
		tranButton.setText("Translate!");
		swapButton.setText("Swap");
		panel.add(tranButton);
		panel.add(swapButton);
		panel.add(output);
		frame.setTitle("pig latin translator-ay");
		frame.setPreferredSize(new Dimension(450,60));
		
		
		frame.pack();
	}
@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static String translateEnglishToPigLatin(String s) {
        String latin = "";
        int i = 0;
        while (i < s.length()) {
            // Take care of punctuation and spaces
            while (i < s.length() && !isLetter(s.charAt(i))) {
                latin = latin + s.charAt(i);
                i++;
            }
            // If there aren't any words left, stop.
            if (i >= s.length())
                break;
            // Otherwise we're at the beginning of a word.
            int begin = i;
            while (i < s.length() && isLetter(s.charAt(i))) {
                i++;
            }
            // Now we're at the end of a word, so translate it.
            int end = i;
            latin = latin + pigWord(s.substring(begin, end));
        }
        return latin;
    }
    
    /**
     * Method to translate a pig latin to english.
     * 
     * @param s
     *            The sentence in pig latin
     * @return The english version
     */
    public static String translatePigLatinToEnglish(String s) {
        String english = "";
        
        String[] words = s.split(" ");
        
        for( String word : words ) {
            String[] hyphenSplit = word.split("-");
            String translatedWord = word;
            String punctuation = "";
            
            if( hyphenSplit.length == 2 ) {
                if( hyphenSplit[1].startsWith("ay")) {
                    // Started with a vowel
                    
                    translatedWord = hyphenSplit[0];
                } else {
                    // Started with a consonant
                    
                    translatedWord = hyphenSplit[1].substring(0, firstVowel(hyphenSplit[1])) + hyphenSplit[0];
                }
                
                // Handle punctuation at the end of a word
                int lastLetterIndex = hyphenSplit[1].length() - 1;
                
                while( !Character.isLetter(hyphenSplit[1].charAt(lastLetterIndex)) ){
                    lastLetterIndex -= 1;
                }
                
                punctuation = hyphenSplit[1].substring(lastLetterIndex + 1);
            }
            
            // Add word
            if( english.isEmpty() ) {
                english += translatedWord + punctuation;
            } else {
                english = english + " " + translatedWord + punctuation;
            }
        }
        
        return english;
    }
    
    
    /**
     * Method to test whether a character is a letter or not.
     * 
     * @param c
     *            The character to test
     * @return True if it's a letter
     */
    private static boolean isLetter(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }

    /**
     * Method to translate one word into pig latin.
     * 
     * @param word
     *            The word in english
     * @return The pig latin version
     */
    private static String pigWord(String word) {
        int split = firstVowel(word);
        return word.substring(split) + "-" + word.substring(0, split) + "ay";
    }

    /**
     * Method to find the index of the first vowel in a word.
     * 
     * @param word
     *            The word to search
     * @return The index of the first vowel
     */
    private static int firstVowel(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++)
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
                    || word.charAt(i) == 'u')
                return i;
        return 0;
    }
}