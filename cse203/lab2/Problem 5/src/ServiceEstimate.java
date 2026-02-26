public class ServiceEstimate {
    double groomingCost;
    double careCharges;
    double tax;
    public ServiceEstimate(double tax) {
        this.tax = tax;
    }
    public double getGroomingCost() {
        return groomingCost;
    }
    public void setGroomingCost(double groomingCost) {
        this.groomingCost = groomingCost;
    }
    public double getCareCharges() {
        return careCharges;
    }
    public void setCareCharges(double careCharges) {
        this.careCharges = careCharges;
    }
    public double getTotal(){
        double total=(groomingCost+careCharges)*(1+tax);
        return total;
    }
}
