public class Cars {
    String make;
    String model;
    int rentalPeriod;
    int mileageLimit;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public int getMileageLimit() {
        return mileageLimit;
    }

    public void setMileageLimit(int mileageLimit) {
        this.mileageLimit = mileageLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("make: ").append(make);
        sb.append(", model: ").append(model);
        sb.append(", rentalPeriod: ").append(rentalPeriod);
        sb.append(", mileageLimit: ").append(mileageLimit);
        return sb.toString();
    }

}
