import java.time.LocalDate;

public class app8 {
    public static void main(String[] args) {
        // Create customer
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhoneNumber("1234567890");

        // Create menu items
        MenuItem item1 = new MenuItem();
        item1.setId(1);
        item1.setName("Pizza");
        item1.setPrice(10.0);
        item1.setUnitsOnHand(50);

        MenuItem item2 = new MenuItem();
        item2.setId(2);
        item2.setName("Burger");
        item2.setPrice(5.0);
        item2.setUnitsOnHand(30);

        // Create order
        Order1 order = new Order1();
        order.setId(1);
        order.setOrderDate(LocalDate.now());
        order.setCustomer(customer);
        order.addMenuItem(item1);
        order.addMenuItem(item2);

        // Set discount
        PercentageDiscount discount = new PercentageDiscount();
        discount.setDiscountPercentage(0.1); // 10% discount

        // Set payment method
        CreditCard paymentMethod = new CreditCard();
        paymentMethod.setCardNumber("1234-5678-9876-5432");

        // Set delivery method
        BikeDelivery deliveryMethod = new BikeDelivery();

        // Process order
        OrderService orderService = new OrderService();
        orderService.setId(1);
        orderService.setProcessDate(LocalDate.now());
        orderService.setDiscount(discount);
        orderService.setPayment(paymentMethod);
        orderService.setDelivery(deliveryMethod);
        
        orderService.process(order);
    }
}
