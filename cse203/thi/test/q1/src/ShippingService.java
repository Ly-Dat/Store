public abstract class ShippingService {
    private String trackingID;
    private String senderName;
    private String receiverName;
    private int packageWeight;
    private ShippingStatus status;
    public ShippingService(String trackingID, String senderName, String receiverName, int packageWeight,
            ShippingStatus status) {
        this.trackingID = trackingID;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.packageWeight = packageWeight;
        this.status = status;
    }
    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
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

    public int getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(int packageWeight) {
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