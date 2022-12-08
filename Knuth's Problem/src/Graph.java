import java.util.*;

public class Graph {

	Number initV, goalV;
	private Hashtable hashT;
	
	public Graph(Number initialValue, Number goalValue) {
	
		this.initV = initialValue;
		this.goalV = goalValue;
		this.hashT = new Hashtable<Double, Double>();
		
	}
	
	public boolean isGoal(Number value) {
		
		return value.floatValue() == this.goalV.floatValue(); 
	}
}
