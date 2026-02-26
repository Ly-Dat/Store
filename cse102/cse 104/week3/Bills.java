
import java.util.Scanner;

public class Bills {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_products = sc.nextInt();
        long pay = 0;
        int i = 0;
        while (true) {
            if (i == 21) {
                i = 20;
            }
            if (num_products > 100) {
                num_products -= 100;
                pay += 100 * (200 - i);
                i++;
            } else {
                pay += num_products * (200 - i);
                break;
            }
        }
        System.out.println(pay);
    }
}
