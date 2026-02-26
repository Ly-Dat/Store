package design_patterns.decorator;

public class Whip extends Decorator{

    public Whip(Beverage beverage) {
            super(beverage);
            //TODO Auto-generated constructor stub
        }
    
        @Override
    String getDescription() {
        return getBeverage().getDescription() + ", Whip";
    }

    @Override
    double getCost() {
        return getBeverage().getCost() + 0.2;
    }
    

}
