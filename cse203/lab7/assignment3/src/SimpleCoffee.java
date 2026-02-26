public class SimpleCoffee implements Coffee{
    private double cost;
    public SimpleCoffee(double cost) {
        this.cost = cost;
    }
    
    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    

}
