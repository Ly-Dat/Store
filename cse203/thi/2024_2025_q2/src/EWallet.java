public class EWallet implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("payed: "+amount+" by E-wallet.");
    }
    
}
