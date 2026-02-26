
public class Card {
    private String[] face = {"Ace","two", "three", "four", "five", "six", "seven", "eight" , "nine", "ten", "Jack", "Queen", "King"};
    private String[] suit = {"Hearts", "Diamonds", "Spades", "Clubs"};

    public String[] getFace() {
        return face;
    }

    public void setFace(String[] face) {
        this.face = face;
    }

    public String[] getSuit() {
        return suit;
    }

    public void setSuit(String[] suit) {
        this.suit = suit;
    }

}
