import java.math.*;
import java.util.*;


public class Node {

	Number initV;
	private int numberOfNodes = 0;
	
	public Node(Number initialValue) {
		
		this.initV = initialValue;
		this.numberOfNodes++;
	}
	
	public ArrayList<Node> Expand() {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		double floorV = Math.floor(this.initV.intValue());
		
		if(this.initV.intValue() == floorV) {
			//Enters here only if the number is Integer
			double factV = this.factorial(this.initV);
			nodes.add(new Node(factV));
		}
		else {
			//Enters here only if the number is double
			nodes.add(new Node(floorV));
		}
		double sqrtV = Math.sqrt(this.initV.floatValue());
		nodes.add(new Node(sqrtV));
		
		return nodes;
	}
	
	private double factorial(Number num) {
		
		if (num.intValue() == 0) {			
			return 1;
		}
		
		return num.intValue() * factorial(num.intValue() - 1);
	}
}
