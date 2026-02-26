public class CreditCard implements PaymentMethod{
    private String cardNumber;

    public String getCardNumber() { 
        return cardNumber; 
    }
    public void setCardNumber(String cardNumber) { 
        this.cardNumber = cardNumber; 
    }
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }

}
