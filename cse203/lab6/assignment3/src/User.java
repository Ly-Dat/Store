public class User {
    public static void main(String[] args) throws Exception {
        ICreditCardPayment user1 = new CardUser("A",100);
        IPayPalPayment user2 = new PayPalUser("B",50);
        System.out.println(user1.pay());
        System.out.println(user2.pay());
    }
}
