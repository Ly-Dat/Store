public class Problem7 {
    public static void main(String[] args) {
        Customer7 customer = new Customer7();
        customer.setName("a");
        customer.setAdrress("123/1 binh duong");
        customer.setLicenseNumber("0912345678");

        Cars cars = new Cars();
        cars.setMake("BMW");
        cars.setModel("i8");
        cars.setRentalPeriod(5);
        cars.setMileageLimit(4000);

        double tax = 0.1;
        RentalAgreement rentalAgreement = new RentalAgreement(tax);
        rentalAgreement.setRentalFee(1000);
        rentalAgreement.setMileageFees(100);

        System.out.println(customer.toString());
        System.out.println(cars.toString());
        System.out.println("Total Rental : ");
        System.out.println(rentalAgreement.getTotalRentalCost());

    }
}
