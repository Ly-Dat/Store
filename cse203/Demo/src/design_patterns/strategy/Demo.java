package design_patterns.strategy;

public class Demo {
    public static void main(String[] args) {
        Order order = new Order();
        PaymentMethod momo = new Momo();
        order.setPaymentMethod(momo);
        PaymentMethod cod = new COD();
        PaymentMethod paypal = new PayPal();
        order.setPaymentMethod(paypal);
        order.pay();

    }
}
