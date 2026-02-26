public class PayPalUser implements IPayPalPayment{
    private String name;
    private double money;
    public PayPalUser(String name, double money) {
        this.name = name;
        this.money = money;
    }
    public String pay(){
        return name+" pay $"+money+" by PayPal";
    }
}
