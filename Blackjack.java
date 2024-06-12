import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	public static final int cardArray[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

	public static void main(String[] args) {
		boolean stay = true;
		int userHand = 0;
		int dealerHand = 0;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		shuffleArray(cardArray);
		for (int i = 0; i < cardArray.length; i++) {
			System.out.print(cardArray[i] + " ");
		}
		System.out.println();


		while(stay) {
            int userDraw = (int)(Math.random() * cardArray.length + 1);
            System.out.println("Type 1 for hit, 2 for stay");
            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.println("You drew a " + userDraw);
                userHand += userDraw;
                System.out.println("Your hand: " + userHand);
                if (userHand > 21) {
                    System.out.println("Bust!");
                    break;
                }
            } else if (choice == 2) {
                stay = false;
                break;
            }
        }

        while (dealerHand < 17) {
            int dealerDraw = (int)(Math.random() * cardArray.length + 1);
            System.out.println("Dealer drew a " + dealerDraw);
            dealerHand += dealerDraw;
            System.out.println("Dealer hand: " + dealerHand);
        }
        
		compareHands(userHand, dealerHand);
	}

	public static void shuffleArray(int[] ar) {
		Random rand = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rand.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	public static void compareHands(int userHand, int dealerHand) {
        System.out.println("User Hand: " + userHand);
        System.out.println("Dealer Hand: " + dealerHand);

        if (userHand > dealerHand && userHand <= 21) {
            System.out.println("User wins!");
        } else if (userHand < dealerHand && dealerHand <= 21) {
            System.out.println("Dealer wins!");
        } else if (userHand > 21 && dealerHand <= 21) {
            System.out.println("Dealer wins!");
        } else if (userHand <= 21 && dealerHand > 21) {
            System.out.println("User wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
