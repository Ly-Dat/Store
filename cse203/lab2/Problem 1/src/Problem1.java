public class Problem1 {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Susan Meyers");
        employee1.setIdNumber(47899);
        employee1.setDepartment("Accounting");
        employee1.setPosition("Vice President");
        
        Employee employee2 = new Employee();
        employee2.setName("Mark Jones");
        employee2.setIdNumber(39119);
        employee2.setDepartment("IT");
        employee2.setPosition("Programmer");

        Employee employee3 = new Employee();
        employee3.setName("Joy Rogers");
        employee3.setIdNumber(81774);
        employee3.setDepartment("Manufacturing");
        employee3.setPosition("Engineer");


        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println(employee3.toString());
    }
}
