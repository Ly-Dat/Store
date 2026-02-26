package design_patterns.decorator;

public class Demo {
    public static void main(String[] args) {
        Beverage houseBlend = new HouseBlend();
        Decorator whip = new Whip(houseBlend);
        Decorator mocha = new Mocha(whip);
        System.out.println(mocha.getDescription());
        System.out.println(mocha.getCost());
    }
}
