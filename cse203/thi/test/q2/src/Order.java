public class Order {
    private String id;
    private double cost;
    private PaymentMethod payment;
    private DiscountStrategy discount;
    public Order(String id, double cost) {
        this.id = id;
        this.cost = cost;
    }
    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }
    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    public double getCost(){
        return discount.calculateCost(cost);
    }
    public void pay(){
        System.out.println("id: "+id);
        System.out.println("cost: "+cost);
        payment.pay(getCost());
    }
    
}
