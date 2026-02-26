public class BikeDelivery implements DeliveryMethod{
    public void process(String orderID) {
        System.out.println("Order " + orderID + " will be delivered by bike.");
    }
}
