public class SavingsAccount extends BankAccount{
    
    public SavingsAccount(double balance, double anuualInterestRate) {
        super(balance, anuualInterestRate);
    }

    public boolean status(){
        if(balance>25){
            return true;
        }
        return false;
    }
    public void withdraw(double money){
        if(status()){
            balance-=money;
            super.withdraw();
        }
    }
    public void deposits(double money){
        if(status()){
            balance+=money;
            super.deposits();
        }
        else if(balance+money>25){
            balance+=money;
            super.deposits();
        }
    }
    public void monthlyProcess(){
        if(numberWithdraw>4 && status()){
            super.monthlyServiceCharges+=(numberWithdraw-4)*1;
            super.monthlyProcess();
        }
    }
}
