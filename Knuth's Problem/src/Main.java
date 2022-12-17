import java.util.Scanner;


public class Main {
		
	public static void main(String[] args) {
		
		double initialNumber = 4.0;
		double goal;
		
		Scanner scanner = new Scanner(System.in);
	  
	    System.out.print("Give me the number you want to find: ");
	    
	    goal = scanner.nextDouble();
	    
	    Graph g = new Graph(initialNumber, goal);
	    
	    int selection;
	    
	    do {
	    	System.out.println("Which Algorithm do you want to use?");
	    	System.out.println("1: BFS \n2: Iterative deepening");	  
	    	selection = scanner.nextInt();
	    	
	    }while(selection != 1 && selection != 2);
	    
	    scanner.close();	  
	    
	    new Algorithm(selection, g).select();
	}
}
