public class ParkedCar {
    String make;
    String model;
    String color;
    String licenseNumber;
    int timeParked;
    public ParkedCar(String make, String model, String color, String licenseNumber, int timeParked) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNumber = licenseNumber;
        this.timeParked = timeParked;
    }
    @Override
    public String toString() {
        return "make: " + make + ", model: " + model + ", color: " + color + ", license number: " + licenseNumber;
    }
    
    
    
}
