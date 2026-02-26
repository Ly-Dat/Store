public class CargoShip extends Ship {
    int capacity;

    public CargoShip(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }
    public String toString(){
        return "name: "+super.name+", ship cargo capacity: "+capacity;
    }
}
