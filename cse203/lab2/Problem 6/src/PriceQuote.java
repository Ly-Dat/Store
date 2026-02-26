public class PriceQuote {
    double cost;
    double laborCharges;
    double deliveryFee;
    double tax;
    public PriceQuote(double tax) {
        this.tax = tax;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getLaborCharges() {
        return laborCharges;
    }

    public void setLaborCharges(double laborCharges) {
        this.laborCharges = laborCharges;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
    public double getTotal(){
        double total = (cost+laborCharges+deliveryFee)*(1+tax);
        return total;
    }
    
}
