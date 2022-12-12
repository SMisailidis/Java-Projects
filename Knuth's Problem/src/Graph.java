import java.util.*;

public class Graph {

	Number initV, goalV;
	Hashtable hashT;
	
	public Graph(Number initialValue, Number goalValue) {
	
		this.initV = initialValue;
		this.goalV = goalValue;
		this.hashT = new Hashtable<Integer, Node>();
	}
	
	public boolean isGoal(Number value) {
		
		return value.floatValue() == this.goalV.floatValue(); 
	}
}
