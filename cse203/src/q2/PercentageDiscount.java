package q2;

public class PercentageDiscount implements DiscountStrategy{
    private double discountPercentage;

    public PercentageDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double execute(double cost) {
        return cost*(100 - discountPercentage)/100;
    }
    

}
