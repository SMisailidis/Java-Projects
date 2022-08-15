
public class Bank {

    private int balance;
    private int BankBalance;
    private Card card;

    public Bank(Card card) {

        this.card = card;

        this.balance = Integer.parseInt(this.card.getBankAccountData().get(0)[0]); //my wallet balance
        this.BankBalance = Integer.parseInt(this.card.getBankAccountData().get(0)[1]);; //my bank balance
    }

    public boolean Deposit(int deposit) {

        String query;

        this.BankBalance += deposit;
        this.balance += deposit;

        query = "UPDATE BANK SET BankMoney =" + '"' + this.BankBalance + '"' + ", CustomerBankAccount =" + '"' + this.balance + '"' + " WHERE BANK.CustomerCardNumber =" + '"' + this.card.getCardData().get(0)[0] + '"';
        
        System.out.println(query);
        return (Main.sql.makeDMLQuery(query));
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
