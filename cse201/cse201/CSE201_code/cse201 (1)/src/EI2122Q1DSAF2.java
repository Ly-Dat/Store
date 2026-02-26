import java.util.*;
import java.io.*;

public class EI2122Q1DSAF2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Integer, Employee> mapEmployees = new TreeMap<>();
        while (n-- > 0) {
            int id = sc.nextInt();
            int checkHour = sc.nextInt();
            if (mapEmployees.containsKey(id)) {
                Employee employee = mapEmployees.get(id);
                if (employee.queueCheckHours.size() > 0) {
                    employee.totalWorkingHour += checkHour - employee.queueCheckHours.poll();
                } else {
                    employee.queueCheckHours.add(checkHour);
                }
            } else {
                mapEmployees.put(id, new Employee(id, checkHour));
            }
        }

        for (Employee e : mapEmployees.values()) {
            sb.append(e.id).append(" ").append(e.totalWorkingHour).append("\n");
        }
        System.out.println(sb);
    }

    static class Employee {
        int id;
        long totalWorkingHour;
        Queue<Integer> queueCheckHours;

        public Employee(int id, int checkInHour) {
            this.id = id;
            this.queueCheckHours = new ArrayDeque<Integer>();
            this.queueCheckHours.add(checkInHour);
        }
    }
}
