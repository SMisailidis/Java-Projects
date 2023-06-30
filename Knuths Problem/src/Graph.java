public class Graph {

	double initV, goalV;
	
	public Graph(double initialValue, double goalValue) {
	
		this.initV = initialValue;
		this.goalV = goalValue;
	}
	
	public boolean isGoal(double value) {
		
		return value == this.goalV; 
	}
}
