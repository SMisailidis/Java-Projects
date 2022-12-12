import java.math.*;
import java.util.*;


public class Node {

	Number initV;
	int numberOfNodes = 0;
	private String text;
	
	public Node(Number initialValue) {
		
		this.initV = initialValue;
		this.numberOfNodes++;
		this.text = "";
	}
	
	public ArrayList<Node> Expand() {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		Number curValue = this.initV;
		
		if(Math.abs(this.initV.floatValue() - this.initV.intValue()) < 0.00000001){
			curValue = this.initV.intValue();
		}
		
		double floorV = Math.floor(curValue.floatValue());

		if(this.initV.doubleValue() == floorV) {
			//Enters here only if the number is Integer
			double factV = this.factorial(curValue.longValue());
			if(factV != 0) {				
				nodes.add(new Node(factV));
				System.out.println("Factorial");
			}
		}
		else {
			//Enters here only if the number is double
			nodes.add(new Node(floorV));
			System.out.println("Floor");
		}
		double sqrtV = Math.sqrt(this.initV.floatValue());
		nodes.add(new Node(sqrtV));
		System.out.println("root");

		return nodes;
	}
	
	private long factorial(long num) {

		if(num > 66) {

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
