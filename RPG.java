import java.util.Random;
import java.util.Scanner;

public class RPG {

	 public static void main(String[] args) {

	 	Scanner scan = new Scanner(System.in);
	 	Random rand = new Random();

	 	String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
	 	int maxEnemyHealth = 75;
	 	int enemyAttackDmg = 25;

	 	int health = 100;
	 	int attackDmg = 50;
	 	int numHealthPots = 3;
	 	int healthPotHeal = 30;
	 	int healthPotDropChance = 25;

	 	boolean running = true;

	 	System.out.println("Welcome to the Dungeon");

	 	GAME:
	 	while(running) {
	 		System.out.println("------------------------------");

	 		int enemyHealth = rand.nextInt(maxEnemyHealth + 1);
	 		String enemy = enemies[rand.nextInt(enemies.length)];
	 		System.out.println("\t# " + enemy + " has appeared! #\n");

	 		while(enemyHealth > 0) {
	 			System.out.println("\tYour HP: " + health);
	 			System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
	 			System.out.println("\n\tWhat would you like to do?");
	 			System.out.println("\t1. Attack");
	 			System.out.println("\t2. Drink health potion");
	 			System.out.println("\t3. Run");

	 			String input = scan.nextLine();
	 			if(input.equals("1")) {
	 				int damageDealt = rand.nextInt(attackDmg) + 1;
	 				int damageTaken = rand.nextInt(enemyAttackDmg) + 1;

	 				enemyHealth -= damageDealt;
	 				health -= damageTaken;

	 				System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
	 				System.out.println("\t> You recieve " + damageTaken + " in retaliation.");

	 				if(health < 1) {
	 					System.out.println("\t> You have taken too much damage, you are too weak to carry on");
	 					break;
	 				}
	 			}	
	 			else if(input.equals("2")) {
	 				if (numHealthPots > 0) {
	 					int healingAmount = Math.min(healthPotHeal, 100 - health);
	 					health += healthPotHeal;
	 					numHealthPots--;
	 					System.out.println("\t> You drink a health potion, healing yourself for " + healthPotHeal + " . "
	 										+ "\n\t> You now have " + health + " HP."
	 										+ "\n\t> You now have " + numHealthPots + " health potions left.\n");
	 				}
	 				else {
	 					System.out.println("\t> You have no health potions left. Defeat an enemy for a chance to obtain one!");
	 				}
	 			}
	 			else if(input.equals("3")) {
	 				System.out.println("\tYou run away from the " + enemy + "!");
	 				continue GAME;
	 			}
	 			else {
	 				System.out.println("\tInvalid Command");
	 			}
	 		}

	 		if (health < 1) {
	 			System.out.println("You limp out of the dungeon. Rest here adventurer.");
	 			break;
	 		}
	 		System.out.println("------------------------------");
	 		System.out.println(" # " + enemy + " was defeated! # ");
	 		System.out.println(" # You have " + health + " HP left. #");
	 		if(rand.nextInt(100) < healthPotDropChance) {
	 			numHealthPots++;
	 			System.out.println(" # The " + enemy + " dropped a health potion! # ");
	 			System.out.println(" # You now have " + numHealthPots + " health potion(s). #");
	 		}
	 		System.out.println("------------------------------");
	 		System.out.println("What would you like to do now?");
	 		System.out.println("1. Explore further");
	 		System.out.println("2. Exit dungeon");

	 		String input = scan.nextLine();

	 		while(!input.equals("1") && !input.equals("2")) {
	 			System.out.println("Invalid command");
	 			input = scan.nextLine();
	 		}
	 		if (input.equals("1")) {
	 			System.out.println("You continue on your adventure");
	 		} else if (input.equals("2")) {
	 			System.out.println("You succesfully exited the dungeon!");
	 			break;
	 		}
		}

		System.out.println("#######################");
		System.out.println("# Thanks for playing! #");
		System.out.println("#######################");


	}
}