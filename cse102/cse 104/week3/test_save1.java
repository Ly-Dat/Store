
import java.util.Scanner;

public class test_save1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = 0;
        double sum_money = 0;
        double[] rate = {0, 3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};
        money = sc.nextLong();
        int month = sc.nextInt();
        int year = month / 12;
        if (year > 0) {
            money *= Math.pow((1 + 0.0692), year);
        }
        month %= 12;
        sum_money += money * (1 + rate[month] * month / 1200);
        System.out.println(Math.round(sum_money));
    }
}
