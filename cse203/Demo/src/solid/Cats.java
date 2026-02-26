package solid;

public class Cats implements Goods{
    private double price;
    
    public Cats(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}
