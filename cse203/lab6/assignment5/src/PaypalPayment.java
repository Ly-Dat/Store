public class PaypalPayment implements PaymentProcessing{
    public boolean processPayment(Order order) {
        System.out.println("Processing PayPal payment for order: " 
        + order.getOrderId() + " with item: "+order.getNameItem());
        return true;
    }
}
