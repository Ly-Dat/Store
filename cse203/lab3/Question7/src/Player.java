public class Player {
    String name;
    int point=50;
    int rollValue;

    public Player(String name) {
        this.name = name;
    }

    public void play(Dice_7 dice){
        dice.roll();
        this.rollValue = dice.getValue();
        if(point-dice.getValue()<1){
            point+=dice.getValue();
        }
        else{
            point-= dice.getValue();
        }
        
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Player: " + name + ", rollValue=" + rollValue + ", point=" + point;
    }
}
