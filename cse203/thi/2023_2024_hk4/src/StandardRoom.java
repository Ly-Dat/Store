public class StandardRoom extends Room{
    private int numBeds;
    public StandardRoom(String ID, double pricePerNight, int numberOfBeds) {
        super(ID, pricePerNight);
        super.setType("StandardRoom");
        this.numBeds = numberOfBeds;
    }
    public int getNumBeds() {
        return numBeds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(super.getID());
        sb.append("\nprice PerNight: "+super.getPricePerNight());
        sb.append("\nstatus: "+super.getStatus());
        sb.append("\nType: ").append(super.getType());
        sb.append("\nnumBeds: ").append(numBeds);
        sb.append("\n"+"-".repeat(30)).append("\n");
        return sb.toString();
    }
    
    
}
