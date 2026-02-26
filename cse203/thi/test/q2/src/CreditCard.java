public class CreditCard implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("cost: "+amount+", pay by credit card.");
    }
    
}
