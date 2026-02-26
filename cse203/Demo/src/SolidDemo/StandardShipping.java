package SolidDemo;

public class StandardShipping extends Shipping{

    public StandardShipping(User sender, User receiver, double weight, Discount discount) {
        super(sender, receiver, weight, discount);
        
    }

    @Override
    public double getCost() {
        double subtotal = 5 + 2*getWeight();
        return getDiscount().execute(subtotal);
    }

    

    

}
