package q1;

public class Demo {
    public static void main(String[] args) {
        ShippingService expressShipping = 
            new ExpressShipping("01", "A", "B", 5, 10, 2);
        expressShipping.setStatus(ShippingStatus.DELIVERED);
        System.out.println(expressShipping);

        ShippingService standardShipping = 
            new StandardShipping("01", "A", "B", 5);
        standardShipping.setStatus(ShippingStatus.DELIVERED);
        System.out.println(standardShipping);
    }
}
