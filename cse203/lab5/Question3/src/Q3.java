public class Q3 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("123","a");
        Employee employee2 = new Employee("132","a1");
        Employee employee3 = new Employee("312","a5");
        EmployeeMap employeeMap = new EmployeeMap();
        employeeMap.add(employee1);
        employeeMap.add(employee2);
        employeeMap.add(employee3);
        System.out.println(employeeMap.get("123"));
        System.out.println(employeeMap.get("134"));
    }
}
