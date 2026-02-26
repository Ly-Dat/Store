public class demo1 {
    public static void main(String[] args) throws Exception {
        IDrivable car = new Car();
        IDrivable truck = new Truck();

        car.drive();
        ((Car) car).carryPassenger();

        truck.drive();
        ((Truck) truck).carryCargo();
        
    }
}
