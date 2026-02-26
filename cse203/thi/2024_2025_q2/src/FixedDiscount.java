public class FixedDiscount implements DiscountStrategy{
    private double discountAmount;
    
    public FixedDiscount(double fixedDiscount) {
        this.discountAmount = fixedDiscount;
    }

    @Override
    public double finalPay(double amount) {
        return (amount - discountAmount);
    }
    @Override
    public String status() {
        return "status: has fixed discount: $"+discountAmount;
    }
    
}
