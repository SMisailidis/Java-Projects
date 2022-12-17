import java.util.ArrayList;
import java.util.LinkedList;

public class Algorithm {

	private int selection;
	private Hash hash;
	private Timer timer;
	private ArrayList<Double> visited;
	private Graph g;
	
	public Algorithm(int selection, Graph g) {
		this.selection = selection;
		this.hash = new Hash();
		this.timer = new Timer();
		this.visited = new ArrayList<Double>();
		this.g = g;
	}

	public void select() {
		
		this.timer.setStartedSeconds();
		this.timer.setAfterOneMinute();
		switch(selection) {
	    	case 1: {
	    		Node found = BFS();
	    		if(found == null) {
	    			System.out.println("I couldn't find the number you wanted!");
	    			System.exit(0);
	    		}
	    		else {	
	    			int index = hash.getKey(found.getInitV());			
	    			startFinder(index, "BFS");
	    		}
	    		break;
	    	}
	    	case 2: {
	    		if(IterativeDeepeningSearch(100000)) {
		    		int index = hash.getKey(this.g.goalV);
		    		startFinder(index, "Iterative Deepening Search");
	    		}
	    		break;
	    	}
		}
	}
	
	private void startFinder(int goalIndex, String algo) {
		
		if(goalIndex != 0.0) {	    			
			this.hash.getPathToGoal(goalIndex, this.g.initV);
			this.hash.printPath();
			this.timer.printTime("BFS");
		}
		else {
			System.out.println("Number not found! Factorial Error");
		}
	}
	
	private Node BFS() {
		
		Node parent = new Node(this.g.initV, null, -1);

		this.hash.add(0, parent);
		
		if(g.isGoal(parent.getInitV())) {
			return parent;
		}
				
		LinkedList<Node> frontier = new LinkedList<Node>();
		frontier.add(parent);
		
		this.visited.add(parent.getInitV());	
		
		while(!frontier.isEmpty()) {
			Node currNode = frontier.poll();
			
			for(Node child : currNode.Expand(this.hash.getKey(currNode.getInitV()))) {
								
				this.timer.checkTime();
				
				double curChildValue = child.getInitV();
				this.hash.add(this.hash.getId(), child);
				
				if(this.g.isGoal(curChildValue)) {
					return child;
				}
				if(!this.visited.contains(curChildValue)) {
					this.visited.add(curChildValue);
					frontier.add(child);
				}
			}
		}
		return null;
	}
	
	private boolean IterativeDeepeningSearch(int limit) {
		
		this.hash.add(0, new Node(this.g.initV, null, -1));
		for(int i=0;i<limit;++i) {
			if(DepthLimitedSearch(this.g.initV, this.g.goalV, i)) {	
				return true;
			}
		}
		return false;
	}

	private boolean DepthLimitedSearch(double initV, double goal, int i) {
		
		this.timer.checkTime();
		
		if(initV == goal) {
			return true;
		}
				
		if(i <= 0) {
			return false;
		}
		
		ArrayList<Node> children = new ArrayList<Node>();
		
		Node parent = new Node(initV, -1);
		
		children = parent.Expand(this.hash.getKey(parent.getInitV()));
		
		for(Node child : children) {
			
			
			if(!this.visited.contains(child.getInitV())) {				
				this.hash.add(this.hash.getId(), child);
				this.visited.add(child.getInitV());
			}
			
			if(DepthLimitedSearch(child.getInitV(), goal, i-1)) {
				return true;
			}
		}
		return false;
	}
}
