import java.util.ArrayList;

public abstract class Characters {
	
	protected String name;
	
	protected int strength; 
	protected int stamina;
	protected int evasion;
	protected int defence;
	protected int accuracy;
	protected int instinct;

	protected ArrayList<Integer> stats = new ArrayList<Integer>();
	protected ArrayList<String> heroNames = new ArrayList<String>();
	
	public void charStats(String fname) {
		
		CSVReader csv = new CSVReader(fname);
		
		int x = csv.names.indexOf(this.name);
		
		stats.add(csv.stats.get(x)[0]);
		stats.add(csv.stats.get(x)[1]);
		stats.add(csv.stats.get(x)[2]);
		stats.add(csv.stats.get(x)[3]);
		stats.add(csv.stats.get(x)[4]);
		stats.add(csv.stats.get(x)[5]);
		
	}
}
