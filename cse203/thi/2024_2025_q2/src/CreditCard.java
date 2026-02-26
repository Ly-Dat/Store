public class CreditCard implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("payed: "+amount+" by credit card.");
    }
    
}
