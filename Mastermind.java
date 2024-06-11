import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    private static final int codeLength = 4;
    private static final int maxGuess = 10;

    public static void main(String[] args) {
        String code = makeCode();
        // System.out.println(code);
        boolean guessed = false;

        for (int i = 0; i < maxGuess; i++) {
            String guess = userInput();
            if (checkGuess(code, guess)) {
                System.out.println("Congratulations! You've guessed the secret code!");
                guessed = true;
                break;
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
        }

        if (!guessed) {
            System.out.println("Out of guesses. The secret code was: " + code);
        }
    }

    public static String makeCode() {
        Random rand = new Random();
        String colors[] = {"red", "green", "blue", "yellow", "purple", "orange"};
        int numColors = 4;
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < numColors; i++) {
            int randomIndex = rand.nextInt(colors.length);
            codeBuilder.append(colors[randomIndex]).append(" ");
        }
        String code = codeBuilder.toString().trim();
        return code;
    }

    public static String userInput() {
        System.out.println("Enter your guess: (four colors separated by a space)");
        Scanner scan = new Scanner(System.in);
        String guess = scan.nextLine().trim().toLowerCase();
        scan.close();
        return guess;
    }

    public static boolean checkGuess(String code, String guess) {
        String[] codeArray = code.split(" ");
        String[] guessArray = guess.split(" ");
        if (guessArray.length != codeArray.length) {
            return false;
        }

        int exactMatch = 0;
        int partialMatch = 0;

        for (int i = 0; i < codeArray.length; i++) {
            if (codeArray[i].equals(guessArray[i])) {
                exactMatch++;
                printColor(guessArray[i], "green");
            } else {
                for (String color : codeArray) {
                    if (color.equals(guessArray[i])) {
                        partialMatch++;
                        printColor(guessArray[i], "yellow");
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < codeLength - exactMatch - partialMatch; i++) {
            printColor("X", "reset");
        }

        System.out.println(); // Print a new line after each guess
        return exactMatch == codeLength;
    }

    public static void printColor(String text, String color) {
        switch (color.toLowerCase()) {
            case "green":
                System.out.print("\u001B[32m" + text + " ");
                break;
            case "yellow":
                System.out.print("\u001B[33m" + text + " ");
                break;
            case "reset":
                System.out.print("\u001B[0m" + text + " ");
                break;
            default:
                System.out.print(text + " ");
                break;
        }
    }
}
