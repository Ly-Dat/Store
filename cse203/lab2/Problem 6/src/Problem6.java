public class Problem6 {
    public static void main(String[] args) {
        Customer6 customer = new Customer6();
        customer.setName("a");
        customer.setAdrress("123/1 binh duong");
        customer.setPhoneNumber("0912345678");

        Records records = new Records();
        records.setTypeCake("birthday cake");
        records.setNumTiers(3);
        records.setEventDay("13/11/2019");

        double tax=0.1;
        PriceQuote priceQuote = new PriceQuote(tax);
        priceQuote.setCost(100);
        priceQuote.setLaborCharges(30);
        priceQuote.setDeliveryFee(10);

        System.out.println(customer.toString());
        System.out.println(records.toString());
        System.out.println("total money: ");
        System.out.println(priceQuote.getTotal());
        
    }
}
