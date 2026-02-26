public class StandardShipping extends ShippingService{
    private double baseFee ;
    private double perKg;
    public StandardShipping(String trackingID, String senderName, String receiverName, int packageWeight, ShippingStatus status) {
        super(trackingID, senderName, receiverName, packageWeight, status);
        this.baseFee = 5;
        this.perKg=1;
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
        sb.append("\nService: ShippingService");
        sb.append("\nStatus: "+super.getStatus());
        sb.append("\nCost: "+calculateCost());
        sb.append("\nStatus: "+super.getStatus().InTransit);
        sb.append("\nStatus: "+super.getStatus().Delivered);
        return sb.toString();
    }

    
}
