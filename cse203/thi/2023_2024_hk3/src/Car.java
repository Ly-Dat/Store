public class Car extends Vehicle{
    private int numDoor;
    private int numSeat;
    private final double[] money = {1560000, 3240000, 4680000, 7080000};
    private final int[] seat = {0, 10, 25, 40};
    public Car(String brand, int year, int numberOfWheels, double productionCost, int numDoor,
            int numSeat) {
        super(brand, year, numberOfWheels, productionCost);
        this.numDoor = numDoor;
        this.numSeat = numSeat;
    }

    @Override
    double calculateOnRoadPrice() {
        double mainternanceFee=0;
        for(int i=0; i<seat.length; i++){
            if(numSeat>=seat[i]){
                mainternanceFee=money[i];
            }
            else{
                break;
            }
        }
        return super.getProductionCost() + super.getProductionCost()*0.1 + 2000000 + mainternanceFee;
    }
    
    
}
