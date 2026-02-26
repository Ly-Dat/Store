public class BookingConfirmation {
    double sessionFee;
    double additionalCharges;
    double tax;

    public BookingConfirmation(double tax) {
        this.tax = tax;
    }

    public double getSessionFee() {
        return sessionFee;
    }

    public void setSessionFee(double sessionFee) {
        this.sessionFee = sessionFee;
    }

    public double getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(double additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public double getTotalPrice(){
        double total = (sessionFee+additionalCharges)*(1+tax);
        return total;
    }
}
