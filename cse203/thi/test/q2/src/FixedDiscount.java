public class FixedDiscount implements DiscountStrategy{
    private double discountAmount;

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    @Override
    public double calculateCost(double cost) {
        System.out.println("Type discount: Fixed discount");
        return cost-discountAmount;
    }
    
}
