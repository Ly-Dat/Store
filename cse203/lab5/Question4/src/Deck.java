
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<String> decks = new ArrayList<>();
    private Card card;
    public Deck() {
        this.card = new Card();
        for(int i=0; i<card.getFace().length; i++){
            for(int j=0; j<card.getSuit().length; j++){
                decks.add(card.getFace()[i]+" of "+card.getSuit()[j]);
            }
        }
    }
    public String getDeck(){
        Random rd = new Random();
        int vt = rd.nextInt(0,52);
        String deck = decks.get(vt);
        if(deck.equals("0")){
            deck=getDeck();
        }
        decks.set(vt, "0");
        return deck;
    }
    public ArrayList<String> getDecks(){
        return decks;
    }
}
