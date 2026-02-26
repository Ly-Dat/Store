package SolidDemo;

public class PercentageDiscount implements Discount{
    private double discountPercent;

    public PercentageDiscount(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double execute(double cost) {
        return cost*(1-discountPercent);
    }
    
}
