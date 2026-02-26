package design_patterns.strategy;

public class Order {
    private PaymentMethod paymentMethod;
    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay()
    {
        paymentMethod.pay();
    }
}
