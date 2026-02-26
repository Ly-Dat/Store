
import java.util.Scanner;

public class bank_fee2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        int sum_sec = 0;
        for (int i = 0; i < n; i++) {
            double money = sc.nextDouble();
            long sec = sc.nextLong();
            sum_sec += sec;
            double fee = 0;
            if (money < 500) {
                fee += 12.0 + 0.2 * sec;
            } else if (money < 2000) {
                fee += 7.5 + 0.2 * sec;
            } else if (money < 5000) {
                fee += 5.0 + 0.1 * sec;
            } else {
                fee = 0;
            }
            sum += fee;
        }
        System.out.printf("%.2f", sum / sum_sec);
    }
}
