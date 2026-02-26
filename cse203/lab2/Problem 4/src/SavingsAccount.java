public class SavingsAccount {
    double annualInterest;
    double startBalance;

    double totalDeposits =0;
    double totalWithdrawals =0;
    double totalInterest= 0;
    double bank;
    public SavingsAccount(double annualInterest, double startBalance) {
        this.annualInterest = annualInterest;
        this.startBalance = startBalance;
        this.bank=startBalance;
    }

    public void withdrawal(double money){
        this.totalWithdrawals+=money;
        this.bank-=money;
    }
    public void deposit(double money){
        this.totalDeposits+=money;
        this.bank+=money;
    }
    public void calculateInterest(){
        double interest = bank*annualInterest/12;
        this.bank+=interest;
        this.totalInterest+=interest;
    }

    public double getTotalDeposits() {
        return totalDeposits;
    }

    public double getTotalWithdrawals() {
        return totalWithdrawals;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public double getBank() {
        return bank;
    }

    @Override
    public String toString() {
        return "ending balance: " + bank + "\ntotal amount of deposits: " + totalDeposits + "\ntotal amount of withdrawals: " + totalWithdrawals
                + "\ntotal interest earned: " + totalInterest ;
    }
    

}
