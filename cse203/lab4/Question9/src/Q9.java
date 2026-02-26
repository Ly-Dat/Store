public class Q9 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(20, 0.24);
        savingsAccount.deposits(15);
        for(int i=0; i<5; i++){
            savingsAccount.withdraw(1);
        }
        savingsAccount.monthlyProcess();
        System.out.println(savingsAccount);
    }
}
