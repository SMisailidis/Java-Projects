import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	
	static ArrayList<Double> visited = new ArrayList<Double>();
	static int id = 0;
	static LocalDateTime afterOneMinute;
	static int seconds;
	static long mseconds;
	static Hash hash = new Hash();
	
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
	    
	    int secondsStart = LocalDateTime.now().getSecond();
	    switch(selection) {
	    	case 1: {
	    		afterOneMinute = LocalDateTime.now().plusMinutes(1);
	    		Node found = BFS(g);
	    		if(found == null) {
	    			System.out.println("I couldn't find the number you wanted!");
	    			System.exit(0);
	    		}
	    		else {	
	    			int index = hash.getKey(found.initV);
	    			if(index != 0.0) {	    			
	    				hash.findPathOfGoal(index, initialNumber);
	    				hash.printPath();
	    				System.out.println("The time needed to find the target with BFS Algorithm was: " + (seconds - secondsStart) + "." + mseconds);
	    			}
	    			else {
	    				System.out.println("Number not found! Factorial Error");
	    			}
	    		}
	    		break;
	    	}
	    	case 2: {
	    		afterOneMinute = LocalDateTime.now().plusMinutes(1);
	    		if(IterativeDeepeningSearch(g, 100000)) {
		    		int index = hash.getKey(goal);
		    		hash.findPathOfGoal(index, initialNumber);
		    		hash.printPath();
	    			System.out.println("The time needed to find the target with Iterative Deepening Search Algorithm was: " + (seconds - secondsStart) + "." + mseconds);
	    		}
	    		break;
	    	}
	    }  
	}
	
	public static Node BFS(Graph g) {
		
		Node parent = new Node(g.initV, null, -1);

		hash.addValue(0, parent);
		
		if(g.isGoal(parent.initV)) {
			return parent;
		}
				
		LinkedList<Node> frontier = new LinkedList<Node>();
		frontier.add(parent);
		
		visited.add(parent.initV);	
		
		while(!frontier.isEmpty()) {
			Node currNode = frontier.poll();
			
			for(Node child : currNode.Expand(hash.getKey(currNode.initV))) {
								
				checkTime();
				
				double curChildValue = child.initV;
				hash.addValue(getId(), child);
				
				if(g.isGoal(curChildValue)) {
					return child;
				}
				if(!visited.contains(curChildValue)) {
					visited.add(curChildValue);
					frontier.add(child);
				}
			}
		}
		return null;
	}
	
	public static boolean IterativeDeepeningSearch(Graph g, int limit) {
		
		hash.addValue(0, new Node(g.initV, null, -1));
		for(int i=0;i<limit;++i) {
			if(DepthLimitedSearch(g.initV, g.goalV, i)) {	
				return true;
			}
		}
		return false;
	}

	public static boolean DepthLimitedSearch(double initV, double goal, int i) {
		
		checkTime();
		
		if(initV == goal) {
			return true;
		}
				
		if(i <= 0) {
			return false;
		}
		
		ArrayList<Node> children = new ArrayList<Node>();
		
		Node parent = new Node(initV, -1);
		
		children = parent.Expand(hash.getKey(parent.initV));
		
		for(Node child : children) {
			
			
			if(!visited.contains(child.initV)) {				
				hash.addValue(getId(), child);
				visited.add(child.initV);
			}
			
			if(DepthLimitedSearch(child.initV, goal, i-1)) {
				return true;
			}
		}
		return false;
	}
	
	public static void checkTime() {
		
		LocalDateTime currTime = LocalDateTime.now();
		seconds = currTime.getSecond();
		mseconds =  TimeUnit.NANOSECONDS.convert(currTime.getNano(), TimeUnit.MILLISECONDS);
		
		if(currTime.getMinute() == afterOneMinute.getMinute() && currTime.getSecond() == afterOneMinute.getSecond()) {
			System.out.println("Search is taking a lot of time, im shutting down!");
			System.exit(0);
		}
	}
	
	public static int getId() {
		id++;
		return id;
	}
}
