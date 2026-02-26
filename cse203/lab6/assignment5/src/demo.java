public class demo{
    public static void main(String[] args) throws Exception {
        Order order = new Order();
        order.addItem("Item1");
        order.addItem("Item2");
        order.orderItem("12345", 150, "Item2");


        OrderValidation validator = new MinimumAmountValidator(100.0);
        // OrderValidation validator = new MinimumAmountValidator(160.0);
        PaymentProcessing paymentProcessor = new CreditCardPayment();
        // PaymentProcessing paymentProcessor = new PaypalPayment();


        OrderFulfillment fulfillment = new OrderFulfillment();
        if (validator.validate(order)) {
            if (paymentProcessor.processPayment(order)) {
                fulfillment.fulfillOrder(order);
            } else {
                System.out.println("there are no that Payment methof for order: " + order.getOrderId());
            }
        } else {
            System.out.println("Can not validate : " + order.getOrderId());
        }
    }
}
