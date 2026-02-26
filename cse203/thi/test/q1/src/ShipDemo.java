public class ShipDemo {
    public static void main(String[] args) throws Exception {
        ShippingService ship1 = new StandardShipping("a123", "An", "Nam", 5, ShippingStatus.Pending);
        System.out.println(ship1.toString());
        System.out.println("-".repeat(30));
        ShippingService ship2 = new ExpressShipping("b27", "Dat", "Ngan", 2, ShippingStatus.Pending);
        System.out.println(ship2.toString());
    }
}
