

public class ExpressShipping extends ShippingService{
    private double baseCost;
    private double perKg;

    public ExpressShipping(String trackingId, String senderName, String receiverName, double packageWeight, ShippingStatus status) {
        super(trackingId, senderName, receiverName, packageWeight, status);
        this.baseCost = 10;
        this.perKg = 2;
    }

    @Override
    double calculateCost() {
        return baseCost + perKg * super.getPackageWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + getID() + "\nSender Name: " + getSenderName() + "\nReceiver Name: "
                + getReceiverName()+"\nshipping by: ExpressShipping");
        sb.append("\nstatus: "+super.getStatus());
        sb.append("\ncost: " + calculateCost());
        sb.append("\nstatus: "+super.getStatus().IN_TRANSIT);
        sb.append("\nstatus: "+super.getStatus().DELIVERED);
        return sb.toString();
    }
    
}
