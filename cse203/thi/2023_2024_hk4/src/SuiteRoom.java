import java.util.ArrayList;

public class SuiteRoom extends Room{
    private ArrayList<String> listSuit;
    public SuiteRoom(String ID, double pricePerNight) {
        super(ID, pricePerNight);
        super.setType("SuiteRoom");
        this.listSuit = new ArrayList<>();
    }
    public void addSuit(String suit){
        listSuit.add(suit);
    }
    public void removeSuit(String suit){
        listSuit.remove(suit);
    }

    public ArrayList<String> getListSuit() {
        return listSuit;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(super.getID());
        sb.append("\nprice PerNight: "+super.getPricePerNight());
        sb.append("\nstatus: "+super.getStatus());
        sb.append("\nType: ").append(super.getType());
        sb.append("\nsuit: "+listSuit.get(0));
        for(int i=1; i<listSuit.size(); i++){
            sb.append(", "+listSuit.get(i));
        }
        sb.append("\n"+"-".repeat(30)).append("\n");
        return sb.toString();
    }
}
