public class MilkDecorator extends CoffeeDecorator{
    private double cost;
    public MilkDecorator(Coffee coffee, double cost) {
        super(coffee);
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }
}
