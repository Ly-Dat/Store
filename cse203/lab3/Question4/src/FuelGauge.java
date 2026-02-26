
public class FuelGauge {

    int fuel = -1;

    public FuelGauge(int fuel) {
        this.fuel = fuel;
    }

    public void PuttingFuel() {
        fuel++;
    }

    public void BurningFuel() {
        fuel--;
    }

    public int getFuel() {
        return fuel;
    }
}
