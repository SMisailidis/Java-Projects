package misailidis_Savvas_1;

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
//-----------------------------------Variables/objects-----------------------------------//
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		player player = new player();
		dealer dealer = new dealer();
		
		int sumP = 0;
		int sumD = 0;
		int hiddenCard = 0;
//---------------------------------------------------------------------------//
		
//-----------------------------------Start-----------------------------------//		
		System.out.println("Welcome to the simplified blackjack game!");
		sumP = player.drawStartPlayer(sumP, random);
		 
		hiddenCard= random.nextInt(11-2) + 2;
		sumD = dealer.drawStartDealer(sumD, random) + hiddenCard;																		
//---------------------------------------------------------------------------//	
		
//-----------------------------------Player-----------------------------------//				
		if(sumP != 21) 
		{
			boolean b = true;
				do 
				{				
					String choice = player.decision(input);
				
					if(choice.equals("hit")) 
					{
						sumP = player.drawIngamePlayer(sumP, random);					
						b = check(sumP);
						player.results(sumP);
					}
					else 
					{
						System.out.println("OK, dealer is playing.");
						System.out.println("His hidden card was " + hiddenCard);
						System.out.println("His total is " + sumD);
						break;
					}
				}while(b);
//----------------------------------------------------------------------------//	
			
//-----------------------------------Dealer-----------------------------------//					
			while(b) 
			{
				if(sumD <= 16)
				{
					System.out.println("\nDealer chooses to hit");
					sumD = dealer.drawIngameDealer(sumD, random);
					
					b = check(sumD);
					dealer.results(sumD);
				}
				else
				{
					System.out.println("\nDealer stays.");
					break;
				}
			}
			if(b) 
			{
				System.out.println("\nDealer total is " + sumD + "\nYour total is " + sumP);
				results(sumP, sumD);
			}	
		}
		else 
		{
			System.out.println("\nBLACKJACK!");
		}
	}
//----------------------------------------------------------------------------//		

//-----------------------------------Common Methods-----------------------------------//	
	public static void results(int  sP, int sD){
		if(sP > sD)
		{
			System.out.println("\nPLAYER WINS!");
		}
		else 
		{
			System.out.println("\nDEALER WINS!");
		}
	}
	
	public static boolean check(int sum){
		boolean D = true;
		if(sum >= 21) 
		{
			D = false;
		}
		return D;
	}
}
//------------------------------------------------------------------------------------//