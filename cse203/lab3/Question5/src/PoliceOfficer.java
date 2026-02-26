public class PoliceOfficer {
    String name;
    String badgeNumber;

    public PoliceOfficer(String name, String badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public boolean examineCar(ParkedCar parkedCar, ParkingMeter parkingMeter){
        int time = parkingMeter.minutesPurchased - parkedCar.timeParked;
        if(time<0){
            return true;
        }
        return false;
    }

    public String issueTicket(ParkingTicket parkingTicket){
        return parkingTicket.generateTicket();
    }

    @Override
    public String toString() {
        return "PoliceOfficer name: " + name + ", badgeNumber: " + badgeNumber;
    }

}
