import java.util.*;


public class Node {

	private double initV;
	private int previous;
	private String operation;
	
	public Node(double initialValue, int previous) {
		
		this.initV = initialValue;
		this.previous = previous;
	}
	
	public Node(double initialValue, String operation, int previous) {
		
		this.initV = initialValue;
		this.operation = operation;
		this.previous = previous;
	}
	
	public ArrayList<Node> Expand(int parentKey) {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		double curValue = this.initV;

		double sqrtV = Math.sqrt(this.initV);
		nodes.add(new Node(sqrtV, "root", parentKey));
		
		if(Math.abs(this.initV - (int)this.initV) < 0.00000001){
			curValue = (int) this.initV;
		}
		
		double floorV = Math.floor(curValue);

		if(this.initV == floorV) {			
			if(curValue < 60) {
				
				double factV = this.factorial(curValue);
				if(factV != 0) {				
					nodes.add(new Node(factV, "Factorial", parentKey));
				}
			}
		}
		else {
			nodes.add(new Node(floorV, "Floor", parentKey));
		}

		return nodes;
	}
	
	private double factorial(double num) {
		
		if (num == 0) {			
			return 1;
		}
		return num * this.factorial(num - 1);
	}
	
	public String getOperation() {
		return operation;
	}
	
	public double getInitV() {
		return initV;
	}

	public int getPrevious() {
		return previous;
	}
}
