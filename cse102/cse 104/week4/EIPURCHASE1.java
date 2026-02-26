import java.util.Scanner;

public class EIPURCHASE1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double moneyItem = sc.nextDouble();
        int numMonth = sc.nextInt();
        double payNow = sc.nextDouble();
        double payment = sc.nextDouble();

        //Phương pháp chia đôi (Bisection)
        double tolerance = 1e-6;
        double lowerBound = 0.0;
        double upperBound = 1.0;
        double rate = 0.0;

        while ((upperBound - lowerBound) > tolerance) {
            rate = (lowerBound + upperBound) / 2.0;
            double fRate = calculateFunction(rate, moneyItem, payNow, payment, numMonth);

            if (fRate == 0.0) {
                break;
            } else if (fRate > 0) {
                upperBound = rate;
            } else {
                lowerBound = rate;
            }
        }

        System.out.printf("%.3f",rate);
    }

    private static double calculateFunction(double rate, double moneyItem, double payNow, double payment, int numMonth) {
        return (moneyItem - payNow) * rate / (1 - Math.pow(1 + rate, -numMonth)) - payment;
    }
}
