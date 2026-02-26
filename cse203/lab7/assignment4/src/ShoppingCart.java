
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ShoppingItem> list;
    public ShoppingCart() {
        this.list = new ArrayList<>();
    }
    public void addItem(ShoppingItem item){
        list.add(item);
    }
    public double calculateTotal(){
        double sum = 0;
        for(var t : list){
            sum+=t.getCost();
        }
        return sum;
    }
    public void pay(PaymentStrategy paymentStrategy) {
        double totalAmount = calculateTotal();
        paymentStrategy.pay(totalAmount);
    }
    
}
