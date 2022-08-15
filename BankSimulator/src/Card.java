import java.util.*;

public class Card {

    private String card;
    private ArrayList<String[]> cardData;
	private ArrayList<String[]> bankAccountData;

	public Card(String card) {
    	
    	this.card = card;
		this.cardData = new ArrayList<String[]>();
		this.bankAccountData = new ArrayList<String[]>();
    	
    	String query = "SELECT * FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";	
		this.cardData = arrayListFill(query);

		query = "SELECT BANK.CustomerBankAccount, BANK.BankMoney FROM BANK WHERE BANK.CustomerCardNumber =" + "'" + this.card + "'";	
		this.bankAccountData = arrayListFill(query);
    }

	public ArrayList<String[]> arrayListFill(String query){

		ArrayList<String[]> arraylist = new ArrayList<String[]>();

		if(Main.sql.makeDMLQuery(query)){	
			arraylist =  Main.spliterator(Main.sql.getQueryResults());
		}

		return arraylist;
	}

	public ArrayList<String[]> getCardData() {
		return cardData;
	}

	public void setCardData(ArrayList<String[]> cardData) {
		this.cardData = cardData;
	}

	public ArrayList<String[]> getBankAccountData() {
		return bankAccountData;
	}

	public void setBankAccountData(ArrayList<String[]> bankAccountData) {
		this.bankAccountData = bankAccountData;
	}
}
