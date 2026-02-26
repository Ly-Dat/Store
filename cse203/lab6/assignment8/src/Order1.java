
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order1 {

    private int id;
    private LocalDate orDate;
    private Customer c;
    private Map<MenuItem, Integer> items;
    static double sum;

    public Order1() {
        this.items = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orDate = orderDate;
    }

    public Customer getCustomer() {
        return c;
    }

    public void setCustomer(Customer customer) {
        this.c = customer;
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public void addMenuItem(MenuItem m) {
        items.put(m, items.getOrDefault(m, 0) + 1);
    }

    public void removeMenuItem(MenuItem m) {
        items.remove(m);
    }

    public double getSubTotal() {
        sum = 0;
        items.forEach((key, val) -> {
            sum += key.getPrice() * val;
        });
        return sum;
    }

}
