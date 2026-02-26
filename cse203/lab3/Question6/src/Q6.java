public class Q6 {
    public static void main(String[] args) {
        Dice dice4 = new Dice(4);
        Dice dice6 = new Dice(6);
        Dice dice8 = new Dice(8);
        Dice dice10 = new Dice(10);
        Dice dice12 = new Dice(12);
        Dice dice20 = new Dice(20);

        Dice dice = dice4;

        dice.roll();
        System.out.println(dice.getSides()+"-sided die rolled: " + dice.getValue());
    }
}
