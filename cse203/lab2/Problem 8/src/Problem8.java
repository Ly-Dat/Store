public class Problem8 {
    public static void main(String[] args) {
        Customer8 customer = new Customer8();
        customer.setName("a");
        customer.setAdrress("123/1 binh duong");
        customer.setPhoneNumber("0912345678");

        Session session = new Session();
        session.setType("wedding");
        session.setDuration(12);
        session.setDate("13/11/2019");

        double tax=0.1;
        BookingConfirmation booking = new BookingConfirmation(tax);
        booking.setSessionFee(100);
        booking.setAdditionalCharges(10);

        System.out.println(customer.toString());
        System.out.println(session.toString());
        System.out.println("total price: ");
        System.out.println(booking.getTotalPrice());

    }
}
