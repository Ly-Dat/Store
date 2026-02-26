public class PercentageDiscount implements DiscountStrategy{
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculateCost(double cost) {
        System.out.println("Type discount: Percentage discount");
        return cost*(1-percent/100);
    }
    
}
