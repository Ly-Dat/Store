package q2;

public class Demo {
    public static void main(String[] args) {
        Order order1 = new Order("01", 100);
        DiscountStrategy fixedDiscount = new FixedDiscount(10);
        PaymentMethod paymentMethod = new CreditCard("123");
        order1.setDiscountStrategy(fixedDiscount);
        order1.setPaymentMethod(paymentMethod);
        order1.applyDiscount();
        order1.pay();

        Order order2 = new Order("02", 200);
        DiscountStrategy p = new PercentageDiscount(10);
        PaymentMethod paymentMethod2 = new EWallet("123E");
        order2.setDiscountStrategy(p);
        order2.setPaymentMethod(paymentMethod2);
        order2.applyDiscount();
        order2.pay();
    }
}
