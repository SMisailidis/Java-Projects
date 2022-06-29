package misailidis_Savvas_1;

import java.util.Random;

public class dealer {
	protected int card;
	protected int card2;
	protected int sum = 0;
	
	public int drawStartDealer(int sum, Random random){
		
		int card = random.nextInt(12-2) + 2;
		sum+= card;
		
		System.out.println("\nThere dealer has a " + card + " showing, and a hidden card");
			
		return sum;
	}

	public int drawIngameDealer(int sum, Random random) {
		
		int card = random.nextInt(12-2) + 2;
		sum += card;
		System.out.println("He draws a " + card + "\nHis total is " + sum);
		
		return sum;
	}
	
	public void results(int sum) {
		if(sum == 21) 
		{
			System.out.println("\nBLACKJACK!\nDEALER WINS!");
		}
		else if(sum > 21) 
		{
			System.out.println("\nDEALER LOSES!");
		}
	}
	
	

}
