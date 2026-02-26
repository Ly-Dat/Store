package solid;

public class Clothes implements Goods{
    private double price;
    
    public Clothes(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
    

}
