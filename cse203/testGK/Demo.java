
public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("a", "a@gmail.com");
        RetailItem item = new RetailItem("book", 10, 20);
        RetailItem item1 = new RetailItem("game", 15, 10);
        customer.addToCart(new CartItem(item, 5));
        customer.addToCart(new CartItem(item, 20));
        customer.addToCart(new CartItem(item, 10));
        customer.addToCart(new CartItem(item1, 10));
        // customer.removeFromCart(new CartItem(item, 0));
        // customer.updateCart(new CartItem(item1, 0), 15);
        System.out.println(customer.viewCart());
    }
}
