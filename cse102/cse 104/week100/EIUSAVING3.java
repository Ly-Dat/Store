
import java.util.Scanner;

public class EIUSAVING3 {

    public static void main(String[] args) {
        double[] rate = {0, 3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};

        Scanner sc = new Scanner(System.in);
        long sum_money = sc.nextLong();
        int month = sc.nextInt();
        int year = month / 12;
        month %= 12;
        double sum = 0;
        if (year > 0) {
            double a = 0;
            for (int i = 1; i <= 11; i++) {
                a += (1 + rate[i] * i / 1200);
            }
            for (int j = 1; j <= year; j++) {
                sum += a * Math.pow(1.0692, j - 1);
                sum += Math.pow(1.0692, j);
            }
        }
        double b = 0;
        for (int i = 1; i <= month; i++) {
            b += (1 + rate[i] * i / 1200);

        }
        sum += b * Math.pow(1.0692, year);
        double money = sum_money / sum;
        System.out.printf("%.4f", money);
    }
}
