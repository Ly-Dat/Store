package design_patterns.decorator;

public class Mocha extends Decorator{

    public Mocha(Beverage beverage) {
            super(beverage);
            
    }
    
    @Override
    String getDescription() {
       return getBeverage().getDescription() + ", Mocha";
    }

    @Override
    double getCost() {
        return getBeverage().getCost() + 0.3;
    }
    

}
