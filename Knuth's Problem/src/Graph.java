public class Graph {

	double initV, goalV;
	
	Array arr;
	
	Hash hashMap;
	
	public Graph(double initialValue, double goalValue) {
	
		this.initV = initialValue;
		this.goalV = goalValue;
		this.arr = new Array();
		this.hashMap = new Hash();
	}
	
	public boolean isGoal(double value) {
		
		return value == this.goalV; 
	}
}
