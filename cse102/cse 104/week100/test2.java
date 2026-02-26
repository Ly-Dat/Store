import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    String name;
    long salaryBeforeTax;
    long salaryAfterTax;

    Employee(String name, long salaryBeforeTax, long salaryAfterTax) {
        this.name = name;
        this.salaryBeforeTax = salaryBeforeTax;
        this.salaryAfterTax = salaryAfterTax;
    }
}

public class test2 {
    static int mil = 1000000;
    static long[] rank = {0, 5*mil, 10*mil, 18*mil, 32*mil, 52*mil, 80*mil, Long.MAX_VALUE};
    static double[] rate = {0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); 
        int k = scanner.nextInt(); 
        long S = scanner.nextLong(); 

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int products = scanner.nextInt();
            long otherDeductions = scanner.nextLong();

            long salaryBeforeTax = products * S;
            long taxableIncome = salaryBeforeTax - 9000000 - otherDeductions;
            long tax = calculateTax(taxableIncome);
            long salaryAfterTax = salaryBeforeTax - tax;

            employees.add(new Employee(name, salaryBeforeTax, salaryAfterTax));
        }

        employees.sort(Comparator.comparingLong((Employee e) -> -e.salaryAfterTax)
                .thenComparing(e -> e.name));


        for (int i = 0; i < Math.min(k, employees.size()-1); i++) {
            Employee emp = employees.get(i);
            int count=0;
            if(employees.get(i + 1).salaryAfterTax == emp.salaryAfterTax){
                count++;
            }
            else{
                sb.append(emp.name + " " + emp.salaryAfterTax);
            }
        }
    }

    private static long calculateTax(long tax) {
        if (tax <= 0) return 0;

        double sum_tax = 0;
        for(int j=1; j<rank.length; j++){
            if(tax>rank[j-1]){
                sum_tax+= Math.min(rank[j]-rank[j-1], tax - rank[j-1])*rate[j-1];
            }
            else{
                break;
            }
        }
        tax=Math.round(sum_tax);
        return tax;
    }
}
