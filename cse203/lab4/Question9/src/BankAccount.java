public class BankAccount {
    double balance;
    int numberDeposits=0;
    int numberWithdraw=0;
    double anuualInterestRate;
    double monthlyServiceCharges=0;

    public BankAccount(double balance, double anuualInterestRate) {
        this.balance = balance;
        this.anuualInterestRate = anuualInterestRate;
    }
    public void deposits(){
        this.numberDeposits++;

    }
    public void withdraw(){
        this.numberWithdraw++;
    }
    public void calcInterest(){
        double monthlyInterestRate = anuualInterestRate/12;
        double monthlyInterest = balance*monthlyInterestRate;
        this.balance+=monthlyInterest;
    }
    public void monthlyProcess(){
        balance-=monthlyServiceCharges;
        calcInterest();
        this.monthlyServiceCharges=0;
        this.numberDeposits=0;
        this.numberWithdraw=0;
    }
    @Override
    public String toString() {
        return "balance: " + balance +", anuualInterestRate: " + anuualInterestRate;
    }
    
}
