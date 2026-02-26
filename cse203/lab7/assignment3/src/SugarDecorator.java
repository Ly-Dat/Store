public class SugarDecorator extends CoffeeDecorator{
    private double cost;
    public SugarDecorator(Coffee coffee, double cost) {
        super(coffee);
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Sugar";
    }
}
