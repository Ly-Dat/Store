package design_patterns.decorator;

public class HouseBlend extends Beverage{

    @Override
    String getDescription() {
        return "House blend";
    }

    @Override
    double getCost() {
        return 0.89;
    }
    

}
