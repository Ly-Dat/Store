public class ExpressShipping extends ShippingService{
    private double baseFee ;
    private double perKg;
    public ExpressShipping(String trackingID, String senderName, String receiverName, int packageWeight, ShippingStatus status) {
        super(trackingID, senderName, receiverName, packageWeight, status);
        this.baseFee = 10;
        this.perKg = 2;
    }
    @Override
    double calculateCost() {
        return baseFee+perKg*super.getPackageWeight();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: "+super.getTrackingID()+"\nSender name: "+
        super.getSenderName()+"\nReceiver name: "+super.getReceiverName());
        sb.append("\nPackage weight: "+super.getPackageWeight());
        sb.append("\nService: ExpressShipping");
        sb.append("\nStatus: "+super.getStatus());
        sb.append("\nCost: "+calculateCost());
        sb.append("\nStatus: "+super.getStatus().InTransit);
        sb.append("\nStatus: "+super.getStatus().Delivered);
        return sb.toString();
    }
}
