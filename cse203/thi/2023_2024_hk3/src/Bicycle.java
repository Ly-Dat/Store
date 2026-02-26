public class Bicycle extends Vehicle{
    String type;

    public Bicycle(String brand, int year, int numberOfWheels, double productionCost, String type) {
        super(brand, year, numberOfWheels, productionCost);
        this.type = type;
    }

    @Override
    double calculateOnRoadPrice() {
        return super.getProductionCost() + 1560000*0.01;
    }
    
}
