public class shipDemo {
    public static void main(String[] args) throws Exception {
        ShippingStatus st = ShippingStatus.PENDING;
        ShippingService expressShipment = new ExpressShipping("EX456", "Charlie", "Diana", 2, st);
        System.out.println(expressShipment);
        System.out.println("-".repeat(30));
        ShippingService standardShipping = new StandardShipping("ST123", "Alice", "Bob", 5.0, st);
        System.out.println(standardShipping);
    }
}
