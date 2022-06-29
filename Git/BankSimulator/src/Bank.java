
public class Bank {

    protected int balance;
    protected int BankBalance;

    public Bank(String card) {

        this.balance = 30; //my wallet balance
        this.BankBalance = 1000; //my bank balance
    }

    public void Deposit(int deposit) {

        this.BankBalance += deposit;
        setBalance(deposit, false);
    }

    public void Withdrawal(int withdrawal) {

        this.BankBalance -= withdrawal;
        setBalance(withdrawal, true);

    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int money, boolean flag) {

        if(!flag) {
            this.balance -= money;
        }
        else {
            if (this.BankBalance - money > 0) {
                this.balance += money;
            }

        }

    }

    public int getBankBalance() {
        return BankBalance;
    }

    public void setBankBalance(int bankBalance) {
        BankBalance = bankBalance;
    }
}
