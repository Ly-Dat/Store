package q2;

public class FixedDiscount implements DiscountStrategy{
    private double discountAmount;

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double execute(double cost) {
        return cost - discountAmount;
    }
    
}
