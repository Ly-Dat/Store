import java.util.*;

public class EIINSORT {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();
        var ListEmployees = new ArrayList<Employee>(length);
        for (int i = 0; i < length; i++) {
            ListEmployees.add(new Employee(sc.nextInt(), sc.nextInt()));
        }
        insertionSort(ListEmployees);

        for (Employee e : ListEmployees) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }

    private static void insertionSort(ArrayList<Employee> listEmployees) {

        for (int j = 1; j < listEmployees.size(); j++) {
            int i = j;
            Employee employee = listEmployees.get(i);
            Employee employee2 = listEmployees.get(i - 1);

            while (i > 0 && employee.monthsSale < employee2.monthsSale) {
                listEmployees.set(i--, employee2);
                if (i > 0)
                    employee2 = listEmployees.get(i - 1);
            }

            listEmployees.set(i, employee);
        }
    }

    static class Employee {
        int id;
        int monthsSale;

        public Employee(int id, int monthsSale) {
            this.id = id;
            this.monthsSale = monthsSale;
        }
        @Override
        public String toString() {
            return id + " " + monthsSale;
        }
    }
}
