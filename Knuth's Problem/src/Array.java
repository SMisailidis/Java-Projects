import java.util.ArrayList;
import java.util.Collections;

public class Array {
	
	ArrayList<ArrayList<Node>> array;
	ArrayList<Node> goalPath;
	int i, index;
	
	public Array() {
		this.array = new ArrayList<ArrayList<Node>>();
		this.i = 0;
		this.goalPath = new ArrayList<Node>();
	}
	
	public void initArray() {
		this.array.add(new ArrayList<Node>());
	}
	
	public void addValue(Node data, int x) {
		this.array.get(x).add(data);
	}
	
	public Number findGoalIndex(Node goal) {
		
		if(this.array.size() == 0) {
			System.out.println("The number you have entered is the same as the goal!");
			System.exit(0);
		}
		
		if(goal == null) {
			return null;
		}
		
		this.goalPath.add(goal);
		
		for(int i=0; i<this.array.size(); i++) {
			for(int j=0; j<this.array.get(i).size(); j++) {
				if(this.array.get(i).get(j).initV == goal.initV) {
					return this.i = i;
				}
			}
		}
		return null;
	}
	
	public void findPathOfGoal(int index) {
		
		if(index == 0) {
			return;
		}
		
		Node previous = this.array.get(index).get(0);
		this.goalPath.add(previous);
		
		for(int i=index-1; i>0;i--) {
			for(int j=1;j<this.array.get(i).size();j++) {
				Node curr = this.array.get(i).get(j);
				if(curr.initV == previous.initV) {
					findPathOfGoal(i);
				}
			}
		}
	}
	
	public void printPath() {
		Collections.reverse(this.goalPath);
		
		for(Node r : this.goalPath) {
			if(r.getText() != null) {	
				System.out.println(r.getText());
			}
		}
	}
	
	
}
