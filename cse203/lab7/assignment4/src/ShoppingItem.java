public class ShoppingItem {
    private double cost;
    private String description;

    public ShoppingItem(String description, double cost) {
        this.cost = cost;
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

}
