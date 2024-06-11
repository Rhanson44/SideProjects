import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		String wordList[] = {"apple", "balloon", "chalk", "drought", "elephant", "fright", "gigantic"};
		int randomWord = rand.nextInt(wordList.length);

		String word = (wordList[randomWord]); 
	
		StringBuilder hideWord = new StringBuilder();
		for (int i = 0; i < word.length(); i++){
			hideWord.append("_");
		}

		System.out.println(hideWord);

		while (hideWord.toString().contains("_")) {

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
			}

			System.out.println(hideWord);
		}
		scan.close();
	}
}