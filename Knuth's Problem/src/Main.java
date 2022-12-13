import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	
	static LocalDateTime afterOneMinute;
	
	public static void main(String[] args) {
		
		double initialNumber = 4.0;
		double goal;
		
		Scanner scanner = new Scanner(System.in);
	  
	    System.out.print("Give me the number you want to find: ");
	    
	    String text = scanner.next();

	    goal = Double.parseDouble(text);
	    
	    Graph g = new Graph(initialNumber, goal);
	    
	    int selection;
	    
	    do {
	    	System.out.println("Which Algorithm do you want to use?");
	    	System.out.println("1: BFS \n2: Iterative deepening");	  
	    	selection = scanner.nextInt();
	    	
	    }while(selection != 1 && selection != 2);
	    
	    scanner.close();
	    switch(selection) {
	    	case 1: {
	    		afterOneMinute = LocalDateTime.now().plusMinutes(1);
	    		Node found = BFS(g);
	    		Number index = g.arr.findGoalIndex(found);
	    		if(index != null) {	    			
	    			g.arr.findPathOfGoal(index.intValue());
	    			g.arr.printPath();
	    		}
	    		else {
	    			System.out.println("Number not found!");
	    		}
	    		
	    		break;
	    	}
	    	case 2: {
	    		afterOneMinute = LocalDateTime.now().plusMinutes(1);
	    		if(IterativeDeepeningSearch(g, 100)) {
		    		double index = g.hashMap.getGoalIndex(goal);
	    			g.hashMap.findPathOfGoal(index, initialNumber);
	    			g.hashMap.printPath();
	    		}
	    		break;
	    	}
	    }
	    
	}
	
	public static Node BFS(Graph g) {
		
		int x=0;
		
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
			g.arr.initArray();
			g.arr.addValue(node, x);
			for(Node child : node.Expand()) {
				
				LocalDateTime currTime = LocalDateTime.now();

				if(currTime.getMinute() == afterOneMinute.getMinute() && currTime.getSecond() == afterOneMinute.getSecond()) {
					System.out.println("Search is taking a lot of time, im shutting down!");
					System.exit(0);
				}
				
				double curChildValue = child.initV;
				g.arr.addValue(child, x);
				
				if(g.isGoal(curChildValue)) {
					return child;
				}
				if(!visited.contains(curChildValue)) {
					visited.add(curChildValue);
					frontier.add(child);
				}
			}
			x++;
		}
		return null;
	}
	
	public static boolean IterativeDeepeningSearch(Graph g, int limit) {
		
		for(int i=0;i<limit;++i) {
			if(DepthLimitedSearch(g.initV, g.goalV, g.hashMap.hash, i)) {	
				return true;
			}
		}
		return false;
	}

	public static boolean DepthLimitedSearch(double initV, double goal, TreeMap<String, Node> hash,  int i) {
		
		LocalDateTime currTime = LocalDateTime.now();

		if(currTime.getMinute() == afterOneMinute.getMinute() && currTime.getSecond() == afterOneMinute.getSecond()) {
			System.out.println("Search is taking a lot of time, im shutting down!");
			System.exit(0);
		}
		
		if(initV == goal) {
			return true;
		}
				
		if(i <= 0) {
			
			return false;
		}
		
		ArrayList<Node> children = new ArrayList<Node>();
		
		children = new Node(initV).Expand();

		for(Node child : children) {
			
			hash.put(Double.toString(initV), child);
			if(DepthLimitedSearch(child.initV, goal, hash, i-1)) {
				return true;
			}
		}
		return false;
	}

}
