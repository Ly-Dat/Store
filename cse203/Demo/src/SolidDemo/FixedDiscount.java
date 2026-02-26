package SolidDemo;

public class FixedDiscount implements Discount{
    private double discountAmount;

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double execute(double cost) {
        return cost - discountAmount;
    }
    

}
