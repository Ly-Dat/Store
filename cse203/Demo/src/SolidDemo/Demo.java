package SolidDemo;

public class Demo {
    public static void main(String[] args) {
        User sender = new User("sender", "123");
        User receiver = new User("receiver", "123");
        Discount fix = new FixedDiscount(10);
        Shipping fast = new FastShipping(sender, receiver, 10, fix);
        Discount p = new PercentageDiscount(0.2);
        fast.setDiscount(p);
        System.out.println(fast.getCost());
    }
}
