package q2;

public class EWallet implements PaymentMethod{
    private String walletID;

    public EWallet(String walletID) {
        this.walletID = walletID;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with EWallet using " + walletID);
    }
    

}
