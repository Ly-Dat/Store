public class Room {
    private String ID;
    private String type;
    private double pricePerNight;
    private boolean isOccupied;

    public Room(String ID, double pricePerNight) {
        this.ID = ID;
        this.pricePerNight = pricePerNight;
        this.isOccupied = false;
        this.type = null;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean  getStatus() {
        return isOccupied;
    }

    public void setStatus(boolean status) {
        this.isOccupied = status;
    }
    
}
