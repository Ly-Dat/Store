public class CardUser implements ICreditCardPayment{
    private String name;
    private double money;
    public CardUser(String name, double money) {
        this.name = name;
        this.money = money;
    }
    public String pay(){
        return name+" pay $"+money+" by credit card";
    }
}
