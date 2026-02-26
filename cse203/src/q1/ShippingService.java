package q1;

public abstract class ShippingService {
    private String id;
    private String senderName;
    private String receiverName;
    private double packageWeight;
    private ShippingStatus status;
    public ShippingService(String id, String senderName, String receiverName, double packageWeight) {
        this.id = id;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.packageWeight = packageWeight;
        this.status = ShippingStatus.PENDING;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public abstract double calculateCost();
    @Override
    public String toString() {
        return "[id=" + id + ", senderName=" + senderName + ", receiverName=" + receiverName
                + ", packageWeight=" + packageWeight + ", status=" + status + "]";
    }
    
}
