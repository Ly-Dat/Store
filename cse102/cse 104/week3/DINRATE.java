
import java.util.Scanner;

public class DINRATE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double money = sc.nextDouble();
            double rate = sc.nextDouble();
            double gain_M = sc.nextDouble();
            int years = 0;
            while (money < gain_M) {
                money += money * rate / 100;
                years++;
            }
            System.out.println(years);
        }

    }
}
