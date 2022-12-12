import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		int initialNumber = 4;
		Number goal;
		
		Scanner scanner = new Scanner(System.in);
	  
	    System.out.print("Give me the number you want to find: ");
	    
	    String text = scanner.next();
	    if(text.contains(".")) {
	    	goal = Double.parseDouble(text);
	    }
	    else {
	    	goal = Integer.parseInt(text);
	    }
	    
	    int selection;
	    
	    do {
	    	System.out.println("Which Algorithm do you want to use?");
	    	System.out.println("1: BFS \n2: Iterative deepening");	  
	    	selection = scanner.nextInt();
	    	
	    }while(selection != 1 && selection != 2);
	    
	    switch(selection) {
	    	case 1: {
	    		Graph g = new Graph(initialNumber, goal);
	    		BFS(g);
	    	}
	    }
	}

	public static Node BFS(Graph g) {
		
		int count=0;
	
		Node node = new Node(g.initV);
		if(g.isGoal(node.initV)) {
			return node;
		}
		
		LinkedList<Node> frontier = new LinkedList<Node>();
		frontier.add(node);
		
		ArrayList<Number> visited = new ArrayList<Number>();
		visited.add(node.initV);	
		
		while(!frontier.isEmpty()) {
			node = frontier.poll();
			
			for(Node child : node.Expand()) {
				Number curChildValue = child.initV;
				if(g.isGoal(curChildValue)) {
					return child;
				}
				if(!visited.contains(curChildValue)) {
					visited.add(curChildValue);
					frontier.add(child);
					g.hashT.put(count, child);
					count++;
				}
			}
		}
		return null;
	}
	
	public static void BestFirstSearch(int source, int target, int v) {
		
	}
	
	public Node IterativeDeepeningSearch() {
		
		return null;
	}
	
}
