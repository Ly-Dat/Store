public class Car implements IDrivable, IPassengerCarrier{
    public void drive(){
        System.out.println("Car is driving");
    }
    public void carryPassenger(){
        System.out.println("Car is carrying passengers");
    }
}
