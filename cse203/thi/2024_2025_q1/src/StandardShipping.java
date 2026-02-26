
public class StandardShipping extends ShippingService {

    private double baseCost;
    private double perKg;

    public StandardShipping(String trackingId, String senderName, String receiverName, double packageWeight, ShippingStatus status) {
        super(trackingId, senderName, receiverName, packageWeight, status);
        this.baseCost = 5;
        this.perKg = 1;
    }

    @Override
    double calculateCost() {
        return baseCost + perKg * super.getPackageWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + getID() + "\nSender Name: " + getSenderName() + "\nReceiver Name: "
                + getReceiverName()+"\nshipping by: StandardShipping");
        sb.append("\nstatus: "+super.getStatus());
        sb.append("\ncost: " + calculateCost());
        sb.append("\nstatus: "+super.getStatus().IN_TRANSIT);
        sb.append("\nstatus: "+super.getStatus().DELIVERED);
        return sb.toString();
    }
    
}
