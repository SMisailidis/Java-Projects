import java.util.*;
import java.util.Map.Entry;

public class Hash {

	TreeMap<Integer, Node> hash;
	ArrayList<Node> pathGoal;
	Integer key, previous;
	Set<Entry<Integer, Node>> entries;
	
	public Hash() {
		this.hash = new TreeMap<Integer, Node>();
		this.pathGoal = new ArrayList<Node>();
		this.entries = this.hash.entrySet();
	}
	
	public void addValue(int id, Node value) {
		this.hash.put(id, value);
	}
	
	public int getKey(double value) {
		
		if(this.hash.size() == 0) {
			System.out.println("The number you have entered is the same as the goal!");
			System.exit(0);
		}
		
		this.entries.forEach(entry -> {
			if(value == entry.getValue().initV) {
				this.key = entry.getKey();
			}
		});
		
		return this.key;
	}
	
	public void findPathOfGoal(int id, double initialNum) {
		
		if(id == -1) {
			return;
		}

		this.pathGoal.add(this.hash.get(id));

		this.entries.forEach(entry -> {
			if(entry.getKey() == id) {
				this.previous = entry.getValue().previous;
			}
		});
		
		findPathOfGoal(this.previous, initialNum);
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
