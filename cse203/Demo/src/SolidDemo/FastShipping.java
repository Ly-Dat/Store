package SolidDemo;

public class FastShipping extends Shipping{

    public FastShipping(User sender, User receiver, double weight, Discount discount) {
        super(sender, receiver, weight, discount);
        
    }

    @Override
    public double getCost() {
        double subtotal = 10 + 2.5*getWeight();
        return getDiscount().execute(subtotal);
    }

    

}
