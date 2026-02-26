
import java.util.Scanner;

public class FinancialFreedom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble() / 100;
        double f = sc.nextDouble() / 100;
        int C = sc.nextInt();

        double minimumAmount
                = (double) C / (r - f);

        long result = Math.round(minimumAmount);

        System.out.println(result);

    }
}
