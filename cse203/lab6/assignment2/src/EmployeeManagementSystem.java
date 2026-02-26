public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee employee1 = new FullTimeEmployee("A", 5, 20);
        Employee employee2 = new PartTimeEmployee("B", 2, 10);
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
    }
}
