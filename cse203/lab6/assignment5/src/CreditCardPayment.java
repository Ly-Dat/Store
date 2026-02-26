public class CreditCardPayment implements PaymentProcessing{
    public boolean processPayment(Order order) {
        System.out.println("Processing Credit Card payment for order: " 
        + order.getOrderId()+ " with item: "+order.getNameItem());
        return true;
    }
}
