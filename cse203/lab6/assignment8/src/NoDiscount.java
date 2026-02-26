public class NoDiscount implements Discount{
    public double execute(double amount) {
        return amount;
    }
}
