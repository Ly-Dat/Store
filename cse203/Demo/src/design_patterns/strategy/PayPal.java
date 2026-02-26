package design_patterns.strategy;

public class PayPal implements PaymentMethod{

    @Override
    public void pay() {
        System.out.println("paid with paypal");
    }

}
