
public class Q4 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        CardPlayer cardPlayer = new CardPlayer();
        for(int i =0; i<5; i++){
            cardPlayer.addDeck(deck.getDeck());
        }
        System.out.println(cardPlayer.showDeck());
    }
}
