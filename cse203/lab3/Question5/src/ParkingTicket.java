public class ParkingTicket {
    int fineAmount;
    ParkedCar parkedCar;
    ParkingMeter parkingMeter;
    PoliceOfficer policeOfficer;

    public ParkingTicket(ParkedCar parkedCar, ParkingMeter parkingMeter, PoliceOfficer policeOfficer) {
        this.parkedCar = parkedCar;
        this.parkingMeter = parkingMeter;
        this.policeOfficer = policeOfficer;
    }

    public String generateTicket(){
        int timeIllegally = parkedCar.timeParked - parkingMeter.minutesPurchased;
        fineAmount=25;
        timeIllegally-=60;
        while(timeIllegally>0){
            fineAmount+=10;
            timeIllegally-=60;
        }
        return "Ticket for: " + parkedCar + "\n" +
               "Fine: $" + fineAmount + "\n" +
               "Issued by: " + policeOfficer;
    }

}
