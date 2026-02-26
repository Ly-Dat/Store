
import java.util.Random;

public class Dice {
    static Random rd = new Random();
    int sides;
    int value;

    public Dice(int numSides) {
        this.sides = numSides;
    }
    public void roll(){
        this.value = rd.nextInt(1,sides);
    }
    public int getSides() {
        return sides;
    }

    public int getValue() {
        return value;
    }
}
