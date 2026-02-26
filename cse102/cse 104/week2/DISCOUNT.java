
import java.util.Scanner;

public class DISCOUNT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long[] amount = {2000000, 10000000, 50000000, 100000000, 200000000, 500000000};
        long[] percent = {3, 5, 7, 10, 12, 15};
        long discount = 0;
        boolean flag = false;
        if (money < 2000000) {
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
