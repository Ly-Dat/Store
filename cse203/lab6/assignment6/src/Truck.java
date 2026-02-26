public class Truck implements IDrivable, ICargoCarrier{
    public void drive(){
        System.out.println("Car is driving");
    }
    public void carryCargo(){
        System.out.println("Car is carrying passengers");
    }
}
