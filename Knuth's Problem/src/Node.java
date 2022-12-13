import java.util.*;


public class Node {

	double initV;
	private String text;
	Node previous, next;
	double depth;
	
	public Node(double initialValue) {
		
		this.initV = initialValue;
	}
	
	public Node(double initialValue, double depth) {
		
		this.initV = initialValue;
		this.depth = depth;
	}
	
	public Node(double initialValue, String type) {
		
		this.initV = initialValue;
		this.text = type;
	}
	
	public ArrayList<Node> Expand() {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		Number curValue = this.initV;

		if(Math.abs(this.initV - (int)this.initV) < 0.00000001){
			curValue = (int) this.initV;
		}
		
		double floorV = Math.floor(curValue.floatValue());

		if(this.initV == floorV) {
			//Enters here only if the number is Integer
			
			if(curValue.longValue() < 60) {
				
				double factV = this.factorial(curValue.longValue());
				if(factV != 0) {				
					nodes.add(new Node(factV, "Factorial"));
				}
			}
		}
		else {
			//Enters here only if the number is double
			nodes.add(new Node(floorV, "Floor"));
		}
		double sqrtV = Math.sqrt(this.initV);
		nodes.add(new Node(sqrtV, "root"));

		return nodes;
	}
	
	private long factorial(long num) {

		if(num > 20) {

			return 0;
		}
		
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
