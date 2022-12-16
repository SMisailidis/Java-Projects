import java.util.*;


public class Node {

	double initV;
	int previous;
	private String text;
	
	public Node(double initialValue, int previous) {
		
		this.initV = initialValue;
		this.previous = previous;
	}
	
	public Node(double initialValue, String type, int previous) {
		
		this.initV = initialValue;
		this.text = type;
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
			//Enters here only if the number is Integer
			
			if(curValue < 60) {
				
				double factV = this.factorial(curValue);
				if(factV != 0) {				
					nodes.add(new Node(factV, "Factorial", parentKey));
				}
			}
		}
		else {
			//Enters here only if the number is double
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
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
