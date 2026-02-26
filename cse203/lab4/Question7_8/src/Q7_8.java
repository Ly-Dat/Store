

public class Q7_8 {
    public static void main(String[] args) {
        Person person = new Person("a", "1/2,abc", "0909098888");
        Customer customer = new Customer("123", false, person);
        PreferredCustomer pc = new PreferredCustomer(500, customer);
        System.out.println(pc);
    }
}
