import java.util.ArrayList;

public class Main {

    public static SQLiteConnection sql;
    public static void main(String[] args) {

        sql = new SQLiteConnection("Cards.db");

        @SuppressWarnings("unused")
        GUISignOrLogIn start = new GUISignOrLogIn();
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