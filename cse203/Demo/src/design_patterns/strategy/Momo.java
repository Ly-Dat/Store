package design_patterns.strategy;

public class Momo implements PaymentMethod{

    @Override
    public void pay() {
        System.out.println("Paid with momo");
    }
    

}
