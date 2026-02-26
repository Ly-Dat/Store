
public class Q4 {

    public static void main(String[] args) {
        FuelGauge fuelGauge = new FuelGauge(15);
        Odometer odometer = new Odometer(fuelGauge);
        if(fuelGauge.getFuel()<=15){
            while (fuelGauge.getFuel() > 0) {
                odometer.run();
                if(fuelGauge.getFuel()>0){
                    System.out.println("current fuel: " + fuelGauge.getFuel() + " ,current mile: " + odometer.getMileage());
                }
                else{
                    System.out.println("Out of fuel");
                }
            }
        }
        else{
            System.out.println("maximum fuel is 15");
        }
    }
}
