public class PaymentDemo {
    public static void main(String[] args) throws Exception {
        Order user1 = new Order("123", 100);
        user1.setPayment(new CreditCard());
        user1.setDiscount(new FixedDiscount(10));
        user1.pay();
        System.out.println("-".repeat(30));
        Order user2 = new Order("abc", 200);
        user2.setPayment(new EWallet());
        user2.setDiscount(new PercentageDiscount(10));
        user2.pay();
    }
}
