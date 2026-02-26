public class AppDemo {
    public static void main(String[] args) throws Exception {
        Order user1 = new Order("123", 100);
        user1.setDiscountStrategy(new FixedDiscount(10));
        user1.setPayment(new CreditCard());
        user1.pay();
        System.out.println("-".repeat(30));
        Order user2 = new Order("233", 200);
        user2.setDiscountStrategy(new PercentageDiscount(10));
        user2.setPayment(new EWallet());
        user2.pay();
    }
}
