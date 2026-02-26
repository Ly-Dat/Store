package SolidDemo;

public abstract class Shipping {
    private User sender;
    private User receiver;
    private double weight;
    private Discount discount;
    public Shipping(User sender, User receiver, double weight, Discount discount) {
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.discount = discount;
    }
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public User getReceiver() {
        return receiver;
    }
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public Discount getDiscount() {
        return discount;
    }
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public abstract double getCost();
}
