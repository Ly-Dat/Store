public class CruiseShip extends Ship{
    int maxPassengers;

    public CruiseShip(String name, int maxPassengers) {
        super(name);
        this.maxPassengers = maxPassengers;
    }
    public String toString(){
        return "name: "+super.name+", maximum number of passengers: "+maxPassengers;
    }
}
