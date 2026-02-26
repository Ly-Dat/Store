public class main4 {
    public static void main(String[] args) throws Exception {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new ShoppingItem("book", 10));
        cart.addItem(new ShoppingItem("TV", 90));
        cart.pay(new CreditCardPayment());
    }
}
