public class Motorcycle extends Vehicle{
    private double maxSpeed;
    private String type;
    public Motorcycle(String brand, int year, int numberOfWheels, double productionCost,
            double maxSpeed, String type) {
        super(brand, year, numberOfWheels, productionCost);
        this.maxSpeed = maxSpeed;
        this.type = type;
    }
    @Override
    double calculateOnRoadPrice() {
        return super.getProductionCost() + super.getProductionCost()*0.05;
    }
}
