public class Q5 {
    public static void main(String[] args) {
        ParkedCar car = new ParkedCar("Toyota", "Corolla", "Red", "ABC123", 130);
        ParkingMeter meter = new ParkingMeter(60);
        PoliceOfficer officer = new PoliceOfficer("John Doe", "12345");
        if (officer.examineCar(car, meter)) {
            ParkingTicket ticket = new ParkingTicket(car, meter, officer);
            System.out.println(officer.issueTicket(ticket));
        } else {
            System.out.println("No violation detected.");
        }
    }
}
