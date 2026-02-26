package design_patterns.strategy;

public class COD implements PaymentMethod{

    @Override
    public void pay() {
        System.out.println("Paid using COD");
    }
    

}
