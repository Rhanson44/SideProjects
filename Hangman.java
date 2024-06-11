import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int lives = 7;

		String wordList[] = {"apple", "balloon", "chalk", "drought", "elephant", "fright", "gigantic"};
		int randomWord = rand.nextInt(wordList.length);

		String word = (wordList[randomWord]); 
	
		StringBuilder hideWord = new StringBuilder();
		for (int i = 0; i < word.length(); i++){
			hideWord.append("_");
		}
		System.out.println(hideWord);

		System.out.println("Guesses left: " + lives);

		while (hideWord.toString().contains("_") && lives > 0) {

			System.out.println("Guess a character");
			char input = scan.next().charAt(0);

			boolean found = false;

			for(int i = 0; i < word.length(); i++) {
				if(word.charAt(i) == input) {
					hideWord.setCharAt(i, input);
					found = true;
			}
		}

			if(found) {
				System.out.println("correct"); 
			} else {
				System.out.println("incorrect");
				lives -= 1;
			}
			System.out.println(hideWord);
			System.out.println("Guesses left: " + lives);
		}
		scan.close();
	}
}