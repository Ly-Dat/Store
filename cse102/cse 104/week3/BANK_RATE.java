
import java.util.Scanner;

public class BANK_RATE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long num_month = sc.nextLong();
        double result = money + money * 0.09 * ((double) num_month / 12);
        System.out.println(result);
    }
}
