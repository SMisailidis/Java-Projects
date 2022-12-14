import java.util.*;

public class Hash {

	TreeMap<String, Node> hash;
	ArrayList<Node> pathGoal;
	String key;
	Set<Map.Entry<String, Node>> entries;
	
	public Hash() {
		this.hash = new TreeMap<String, Node>();
		this.pathGoal = new ArrayList<Node>();
		this.entries = this.hash.entrySet();
	}
	
	public double getGoalIndex(double goal) {
		
		
		if(this.hash.size() == 0) {
			System.out.println("The number you have entered is the same as the goal!");
			System.exit(0);
		}
		
		this.entries.forEach(entry -> {
			if(goal == entry.getValue().initV) {
				this.key = entry.getKey();
			}
		});
		
		return Double.parseDouble(this.key);
	}
	
	public void findPathOfGoal(double index, double initialNum) {
		
		
		if(index == 0) {
			return;
		}
		
		this.pathGoal.add(this.hash.get(Double.toString(index)));
		if(index != initialNum) {
			
			double value = index; 
			
			this.hash.remove(Double.toString(index));
			
			this.entries.forEach(entry -> {
				if(value == entry.getValue().initV) {
					this.key = entry.getKey();
				}
			});
			findPathOfGoal(Double.parseDouble(this.key), initialNum);
		}

		return;	
	}
	
	public void printPath() {
		Collections.reverse(this.pathGoal);
		
		for(Node r : this.pathGoal) {
			if(r.getText() != null) {	
				System.out.println(r.getText());
			}
		}
	}
}
