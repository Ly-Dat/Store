import java.util.ArrayList;

public class workDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, "123 Main St", 123456789, "alice@example.com", 20000000, 2));
        employees.add(new Employee("Bob", 40, "456 Elm St", 987654321, "bob@example.com", 15000000, 1));
        employees.add(new Employee("Charlie", 35, "789 Oak St", 555666777, "charlie@example.com", 12000000, 0));

        double totalTax = 0;
        for (Person emp : employees) {
            double tax = emp.calculateIncomeTax();
            totalTax += tax;
            System.out.println("Income Tax for " + emp.getName() + ": " + tax);
        }

        System.out.println("Total Personal Income Tax for all employees: " + totalTax);
    }
}
