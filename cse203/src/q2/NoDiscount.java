package q2;

public class NoDiscount implements DiscountStrategy{

    @Override
    public double execute(double cost) {
        return cost;
    }
    
}
