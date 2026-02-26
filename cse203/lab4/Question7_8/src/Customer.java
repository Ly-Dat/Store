public class Customer {
    String customerNumber;
    boolean wishMailing;
    Person person;
    public Customer(String customerNumber, boolean wishMailing, Person person) {
        this.customerNumber = customerNumber;
        this.wishMailing = wishMailing;
        this.person = person;
    }
    @Override
    public String toString() {
        return person+ "customer number: " + customerNumber + ", wish to be on a mailing list: " + (wishMailing?"yes":"no")+"\n";
    }
    
}
