package q1;

public class StandardShipping extends ShippingService{
    private final double BASE_COST = 5;
    private final double PER_KG = 1;

    public StandardShipping(String id, String senderName, String receiverName, double packageWeight)
    {
        super(id, senderName, receiverName, packageWeight);
    }

    @Override
    public double calculateCost() {
        return BASE_COST + getPackageWeight()*PER_KG;
    }

    @Override
    public String toString() {
        return "StandardShipping " + super.toString() + ", cost = [" + calculateCost() + "]";
    }
    
    

}
