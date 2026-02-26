public class Odometer {
    int mileage;
    FuelGauge fuelGauge;
    int countMileage = 0;

    public Odometer(FuelGauge fuelGauge) {
        mileage = 0;
        this.fuelGauge = fuelGauge;
    }
    
    public void run(){
        countMileage++;
        if(mileage<999999){
            mileage++;
            if(countMileage == 24){
                updateFuel();
                countMileage=0;
            }
        }
        else{
            mileage=0;
        }
    }

    public int getMileage() {
        return mileage;
    }

    private void updateFuel() {
        fuelGauge.BurningFuel();
    }

}
