
import java.util.Scanner;

public class DISCOUNT2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long[] amount = {5000000, 20000000, 100000000, 300000000, 600000000, 900000000};
        long[] percent = {3, 5, 7, 10, 12, 15};
        long discount = 0;
        boolean flag = false;
        if (money < 5000000) {
            System.out.println(money);
        } else {
            for (int i = 1; i < amount.length; i++) {
                if (money <= amount[i]) {
                    discount += (money - amount[i - 1]) * percent[i - 1] / 100;
                    flag = true;
                    break;
                }
                discount += (amount[i] - amount[i - 1]) * percent[i - 1] / 100;
            }

            if (!flag) {
                discount += (money - amount[amount.length - 1]) * percent[percent.length - 1] / 100;
            }
            System.out.println(money - discount);
        }
    }
}
