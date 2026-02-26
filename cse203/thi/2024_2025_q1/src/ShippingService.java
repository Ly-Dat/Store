public abstract class ShippingService {
    private String trackingId;
    private String senderName;
    private String receiverName;
    private double packageWeight;
    private ShippingStatus status;

    public ShippingService(String trackingId, String senderName, String receiverName, double packageWeight, ShippingStatus status) {
        this.packageWeight = packageWeight;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.status = status;
        this.trackingId = trackingId;
    }

    public String getID() {
        return trackingId;
    }

    public void setID(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(double packageWeight) {
        this.packageWeight = packageWeight;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }
    abstract double calculateCost();
}