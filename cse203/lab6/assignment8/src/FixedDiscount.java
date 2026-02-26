public class FixedDiscount implements Discount{
    private double discountAmount;

    public double getDiscountAmount() { 
        return discountAmount; 
    }
    public void setDiscountAmount(double discountAmount) { 
        this.discountAmount = discountAmount; 
    }

    public double execute(double amount) {
        return amount - discountAmount;
    }
}
