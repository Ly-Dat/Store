public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Total amount: $" + amount);
        System.out.println("Paid using Credit Card");
    }
    
}
