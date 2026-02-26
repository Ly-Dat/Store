
import java.util.Scanner;

public class EIUSAVING1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rates = {3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};
        double money = sc.nextLong();
        int month = sc.nextInt();
        if (month > 12) {
            int i = month / 12;
            for (int j = 0; j < i; j++) {
                money += money * rates[rates.length - 1] / 100;
            }
            month = month % 12;
        }
        money += money * ((double) month / 12) * rates[month - 1] / 100;
        System.out.println(Math.round(money));
    }
}
