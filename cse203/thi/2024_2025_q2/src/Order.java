public class Order {
    private String id;
    private double cost;
    private PaymentMethod payment;
    private DiscountStrategy discountStrategy;
    public Order(String id, double cost) {
        this.id = id;
        this.cost = cost;
    }
    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public double getTotalPay(){
        return discountStrategy.finalPay(cost);
    }
    public void pay(){
        System.out.println("User: "+id+"\ncost: $"+cost);
        System.out.println(discountStrategy.status());
        payment.pay(getTotalPay());
        
    }

}
