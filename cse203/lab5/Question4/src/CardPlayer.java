
import java.util.ArrayList;

public class CardPlayer {
    private ArrayList<String> arrDeck ;
    
    public CardPlayer() {
        this.arrDeck = new ArrayList<>();
    }
    public void addDeck(String deck){
        arrDeck.add(deck);
    }
    public String showDeck(){
        StringBuilder sb = new StringBuilder();
        arrDeck.forEach(p->sb.append(p+"\n"));
        return sb.toString();
    }
}
