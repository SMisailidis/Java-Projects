import java.util.*;

public class Card {

    private String card;
    private ArrayList<String> cardData = new ArrayList<String>();
  
    
	public Card(String card) {
    	
    	this.card = card;
    	
    	SQLiteConnection sqlConn = new SQLiteConnection();
    	
    	String query = "SELECT * FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";
    	
    	if(sqlConn.makeDMLQuery(query)) {
    		
    		this.cardData = sqlConn.getQueryResults();
    	}
    	
    }
	
	public ArrayList<String> getCardData() {
		return this.cardData;
	}
}
