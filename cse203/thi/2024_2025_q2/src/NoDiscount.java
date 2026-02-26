public class NoDiscount implements DiscountStrategy{

    @Override
    public double finalPay(double amount) {
        return amount;
    }

    @Override
    public String status() {
        return "status: no discount";
    }

   
    
}
