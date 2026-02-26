package q1;


public class ExpressShipping extends ShippingService{
    private double baseCost;
    private  double perKg;
    

    public ExpressShipping(String id, String senderName, String receiverName, double packageWeight, double baseCost,
            double perKg) {
        super(id, senderName, receiverName, packageWeight);
        this.baseCost = baseCost;
        this.perKg = perKg;
    }

    @Override
    public double calculateCost() {
        return baseCost + getPackageWeight()*perKg;
    }

    @Override
    public String toString() {
        return "ExpressShipping " + super.toString() + ", cost = [" + calculateCost() + "]";
    }
    
    

}
