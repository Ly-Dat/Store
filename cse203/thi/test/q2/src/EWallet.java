public class EWallet implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("cost: "+amount+", pay by E-Wallet.");
    }
    
}
