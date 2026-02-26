package solid;

public class Shoes implements Goods{
    private double price;

    public Shoes(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}
