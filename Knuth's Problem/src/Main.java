import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		int initialNumber = 4;
		
		Scanner scanner = new Scanner(System.in);
	  
	    System.out.print("Give me the number you want to find: ");
	    
	    int goal = scanner.nextInt();
	    int selection;
	    
	    do {
	    	System.out.println("Which Algorithm do you want to use?");
	    	System.out.println("1: BFS \n2: Iterative deepening");	  
	    	selection = scanner.nextInt();
	    }while(selection != 1 && selection != 2);
	    
	    switch(selection) {
	    	case 1: {
	    		BFS(new Graph(initialNumber, goal));
	    	}
	    }
	}

	public static Node BFS(Graph g) {
	
		Node node = new Node(g.initV);
		if(g.isGoal(node.initV.floatValue())) {
			return node;
		}
		
		return null;
	}
	
	public Node IterativeDeepeningSearch() {
		
		return null;
	}
	
}
