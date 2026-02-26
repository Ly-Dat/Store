import java.time.LocalDate;

public class OrderService {
    private int id;
    private LocalDate processDate;
    private Discount discount;
    private PaymentMethod payment;
    private DeliveryMethod delivery;

    public OrderService() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getProcessDate() { return processDate; }
    public void setProcessDate(LocalDate processDate) { this.processDate = processDate; }

    public Discount getDiscount() { return discount; }
    public void setDiscount(Discount discount) { this.discount = discount; }

    public PaymentMethod getPayment() { return payment; }
    public void setPayment(PaymentMethod payment) { this.payment = payment; }

    public DeliveryMethod getDelivery() { return delivery; }
    public void setDelivery(DeliveryMethod delivery) { this.delivery = delivery; }

    public void process(Order1 order) {
        double amount = order.getSubTotal();
        double discountedAmount = discount.execute(amount);
        payment.pay(discountedAmount);
        delivery.process(String.valueOf(order.getId()));
    }
}
