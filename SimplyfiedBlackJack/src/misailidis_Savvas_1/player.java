package misailidis_Savvas_1;

import java.util.Random;
import java.util.Scanner;

public class player {
	protected int card;
	protected int card2;
	protected int sum = 0;
	

	public int drawStartPlayer(int sum, Random random){
		
		int card1 = random.nextInt(12-2) + 2;
		int card2= random.nextInt(12-2) + 2;
		sum+= card1 + card2;
		
		System.out.println("You get a " + card1 + " and " + card2);
		System.out.println("Your total is " + sum);
			
		return sum;
	}
	
	public int drawIngamePlayer(int sum, Random random) {
		
		int card = random.nextInt(12-2) + 2;
		sum += card;
		
		System.out.println("You draw a " + card + "\nYour total is " + sum);
		
		return sum;
	}
	
	public String decision(Scanner input) {
		
		System.out.println("\nWould you like to \"hit\" or \"stay\"?");
		String choice;
		do {
			choice = input.next();
		}while(!choice.equals("hit") && !choice.equals("stay"));
		
		return choice;
	}

	public void results(int sum) {
		if(sum == 21) 
		{
			System.out.println("\nBLACKJACK!\nPLAYER WINS!");
		}
		else if(sum > 21) 
		{
			System.out.println("\nPLAYER LOSES!");
		}
	}
}
