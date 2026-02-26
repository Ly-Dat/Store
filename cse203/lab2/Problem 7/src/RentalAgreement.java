public class RentalAgreement {
    double rentalFee;
    double mileageFees;
    double tax;

    public RentalAgreement(double tax) {
        this.tax = tax;
    }
    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public double getMileageFees() {
        return mileageFees;
    }

    public void setMileageFees(double mileageFees) {
        this.mileageFees = mileageFees;
    }
    public double getTotalRentalCost(){
        double total = (rentalFee+mileageFees)*(1+tax);
        return total;
    }
}
