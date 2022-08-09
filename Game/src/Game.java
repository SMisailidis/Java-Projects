import java.util.ArrayList;

public class Game {

	public static SQLiteConnection sql;
	protected static ArrayList<Heroes> selectedHeroes = new ArrayList<>();

	public static void main(String[] args) {

		sql = new SQLiteConnection("Characters.db");

		HeroSelectGUI w = new HeroSelectGUI();
	}
	
	public static void select(String name) {

		ArrayList<String[]> results = new ArrayList<String[]>();
		String query = "SELECT * FROM HEROES WHERE name=" + '"' + name + '"';
		String receivedData = "";

		if(sql.makeDMLQuery(query)){
			receivedData = sql.getQueryResults();
			results = spliterator(receivedData);
		}

		selectedHeroes.add(new Heroes(results));
	}

	public static ArrayList<String[]> spliterator(String receivedData){

		ArrayList<String[]> results = new ArrayList<String[]>();

		String[] resultArray = receivedData.split("/");

		for (String r : resultArray) {
			results.add(r.split("@"));
		}

		return results;
	}
}