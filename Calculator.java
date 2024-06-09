import java.util.Scanner;

public class Calculator {

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		int add = 1;
		int sub = 2;
		int mult = 3;
		int div = 4;
		int exit = 5;
		boolean isTrue = true;

		System.out.println("Enter first number:");
		double num1 = scan.nextDouble();

		System.out.println("Enter second number:");
		double num2 = scan.nextDouble();

		while (isTrue) {
		System.out.println("Choose operator:");
		System.out.println("1: +, 2: -, 3: *, 4: /, 5: Exit");
		int operator = scan.nextInt();

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
					System.out.println("Goodbye");
					isTrue = false;
					break;
				default:
					System.out.println("Please enter a valid operator");
					break;
			}
		}
		scan.close();
	}
}