import java.util.*;
public class Card {

    private String card;
    private ArrayList<String> cardData;
	private ArrayList<String> bankAccountData;
	private SQLiteConnection sqlConn;

	public Card(String card) {
    	
    	this.card = card;
		this.cardData = new ArrayList<String>();
		this.bankAccountData = new ArrayList<String>();
    	
    	this.sqlConn = new SQLiteConnection();
    	
    	String query = "SELECT * FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";	
		arrayListFill(query, this.cardData);

		query = "SELECT BANK.CustomerBankAccount, BANK.BankMoney FROM BANK WHERE BANK.CustomerCardNumber =" + "'" + this.card + "'";	
		arrayListFill(query, this.bankAccountData);
    }

	public void arrayListFill(String query,ArrayList<String> arrayList){

		if(this.sqlConn.makeDMLQuery(query)){
			arrayList.addAll(this.sqlConn.getQueryResults());
		}
	}

	public ArrayList<String> getCardData() {
		return cardData;
	}

	public void setCardData(ArrayList<String> cardData) {
		this.cardData = cardData;
	}

	public ArrayList<String> getBankAccountData() {
		return bankAccountData;
	}

	public void setBankAccountData(ArrayList<String> bankAccountData) {
		this.bankAccountData = bankAccountData;
	}
}
