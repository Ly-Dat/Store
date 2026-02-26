public class NoDiscount implements DiscountStrategy{
    @Override
    public double calculateCost(double cost) {
        System.out.println("Type discount: No discount");
        return cost;
    }
    
}
