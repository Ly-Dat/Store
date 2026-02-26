package design_patterns.decorator;

public abstract class Decorator extends Beverage{
    private Beverage beverage;
    
    public Decorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public Beverage getBeverage() {
        return beverage;
    }
    
   
}
