public abstract class Vehicle {
    private String brand;
    private int year;
    private int numberOfWheels;
    private double productionCost;
    private double onRoadPrice;
    
    public Vehicle(String brand, int year, int numberOfWheels, double productionCost) {
        this.brand = brand;
        this.year = year;
        this.numberOfWheels = numberOfWheels;
        this.productionCost = productionCost;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    public double getOnRoadPrice() {
        return onRoadPrice;
    }

    public void setOnRoadPrice(double onRoadPrice) {
        this.onRoadPrice = onRoadPrice;
    }

    abstract double calculateOnRoadPrice();
}
