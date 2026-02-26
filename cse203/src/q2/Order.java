package q2;

public class Order {
    private String id;
    private double cost;
    private PaymentMethod paymentMethod;
    private DiscountStrategy discountStrategy;
    public Order(String id, double cost) {
        this.id = id;
        this.cost = cost;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    public void applyDiscount(){
        cost = discountStrategy.execute(cost);
    }

    public void pay(){
        paymentMethod.pay(cost);
    }
}
