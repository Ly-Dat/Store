public class PercentageDiscount implements DiscountStrategy{
    private double percent;
    
    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double finalPay(double amount) {
        return amount*(1-percent/100);
    }
    @Override
    public String status() {
        return "status: has percentage discount: "+percent+"%";
    }
    
}
