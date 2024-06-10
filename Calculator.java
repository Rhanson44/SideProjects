import java.util.Scanner;

public class Calculator {

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		int choice;
		int operator;
		int add = 1;
		int sub = 2;
		int mult = 3;
		int div = 4;
		boolean isTrue = true;

		while (isTrue) {

			System.out.println("Choose operator:");
			System.out.println("1: +, 2: -, 3: *, 4: /");
			operator = scan.nextInt();

			System.out.println("Enter first number:");
			double num1 = scan.nextDouble();

			System.out.println("Enter second number:");
			double num2 = scan.nextDouble();

		switch(operator) {
			case 1:
				System.out.println(num1 + num2);
				break;
			case 2:
				System.out.println(num1 - num2);
				break;
			case 3:
				System.out.println(num1 * num2);
				break;
			case 4:
				System.out.println(num1 / num2);
				break;
			case 5:
			default:
				System.out.println("Error: please enter a valid operator");
				break;
			}
		System.out.println ("Continue? 1 for yes, 2 for no");
		choice = scan.nextInt();
		if(choice == 2) {
			System.out.println("Goodbye");
			isTrue = false;
		}
		else
			isTrue = true;
		}
		scan.close();
	}
}