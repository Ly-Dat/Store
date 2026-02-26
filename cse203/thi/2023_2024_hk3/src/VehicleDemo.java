public class VehicleDemo {
    public static void main(String[] args) throws Exception {
        Vehicle car = new Car("Toyota", 2023, 4, 500000000, 4, 5);
        System.out.println("Car Rolling Price: " + String.format("%.2f", car.calculateOnRoadPrice())+ " VND");

        Motorcycle motorcycle = new Motorcycle("Honda", 2023, 2, 40000000, 120, "scooter");
        System.out.println("Motorcycle Rolling Price: " + String.format("%.2f", motorcycle.calculateOnRoadPrice()) + " VND");

        Bicycle bicycle = new Bicycle("Giant", 2023, 2, 10000000, "terrain bike");
        System.out.println("Bicycle Rolling Price: " + String.format("%.2f", bicycle.calculateOnRoadPrice()) + " VND");
    }
}
