
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String nameItem;
    private String orderId;
    private List<String> items;
    private int totalAmount;
    public Order() {
        this.items = new ArrayList<>();
    }
    public void orderItem(String orderId, int totalAmount, String nameItem){
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.nameItem = nameItem;
    }
    public String getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void addItem(String item){
        items.add(item);
    }
}
