public class COD implements PaymentMethod{
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash on Delivery.");
    }
}
