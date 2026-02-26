public class main1 {
    public static void main(String[] args) {
        ShoesServicesTicket ticket = new ShoesServicesTicket(1, "John Doe", "Nike", "Air Max", "Black", "Sneakers", 50.0f, "Washing, Repair", 10.0f);
        System.out.println("Payment: " + ticket.getPayment());
    }
}
