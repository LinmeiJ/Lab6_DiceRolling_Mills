import java.util.Random;
import java.util.Scanner;

public class Lab6DiceRoll_Mills {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		
		String startRoll = "y";
		while(startRoll.equalsIgnoreCase("y")) {
			System.out.println("How many side should each dice have: ");
			int numOfSides = sc.nextInt();
			
			int dice1 = generateRandomDieRoll(numOfSides);
			int dice2 = generateRandomDieRoll(numOfSides);
			
			System.out.println("Roll " + i + ": \n" + dice1 +" \n" + dice2);
			
			getSpecialMsg(dice1, dice2, numOfSides, i);
			
			System.out.println("Roll again(y/n): ");
			startRoll = sc.next();
			
			i++;
		}
		System.out.println("Goodbye!");
		sc.close();
	}

	
	public static int generateRandomDieRoll(int num){
		int result;
		
	//  result = (int)(Math.random()*num + 1); //this is using the math method to generate the random number
		
		Random rand = new Random(); // this is using the java random class to generate the random number
		result = rand.nextInt(num) + 1;
		
		return result;
	}
	
	/*********************extended challenges**************************/
	public static void getSpecialMsg(int d1, int d2, int num, int firstRoll) {
		// only the highest number in each dice prints "box cars"
		if(d1 == num && d2 == num) {
			System.out.println("box cars");
		}
		// only the lowest number(which is 1) in each dice prints "snake eye"
		else if(d1 == 1 && d2 == 1) {
			System.out.println("snake eyes");
		}
		// caps: only if it is the first roll and also satifiy the if statement
		//		 condition, then print out "craps".
		else if(firstRoll == 1) {
			if(d1 == num/2 && d2 == num/2) {
			System.out.println("craps");
			}
		}
	}
}
