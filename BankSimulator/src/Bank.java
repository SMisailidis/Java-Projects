
public class Bank {

    private int balance;
    private int BankBalance;
    private SQLiteConnection sqlConn;
    private Card card;

    public Bank(Card card) {

        this.sqlConn = new SQLiteConnection();
        this.card = card;

        this.balance = Integer.parseInt(card.getBankAccountData().get(0)); //my wallet balance
        this.BankBalance = Integer.parseInt(card.getBankAccountData().get(1));; //my bank balance
    }

    public boolean Deposit(int deposit) {

        String query;

        this.BankBalance += deposit;
        this.balance += deposit;

        query = "UPDATE BANK SET BankMoney =" + '"' + this.BankBalance + '"' + ", CustomerBankAccount =" + '"' + this.balance + '"' + " WHERE BANK.CustomerCardNumber =" + '"' + this.card.getCardData().get(0) + '"';
        
        System.out.println(query);
        return (sqlConn.makeDMLQuery(query));
    }

    public void Withdrawal(int withdrawal) {

        this.BankBalance -= withdrawal;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getBankBalance() {
        return BankBalance;
    }

    public void setBankBalance(int bankBalance) {
        BankBalance = bankBalance;
    }
}
