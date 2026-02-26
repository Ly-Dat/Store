
import java.util.Scanner;

public class TAX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        money -= 9000000;
        long[] amount = {0, 5000000, 10000000, 18000000, 32000000, 52000000, 80000000};
        long[] percent = {5, 10, 15, 20, 25, 30, 35};
        long discount = 0;
        boolean flag = false;

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
        if(money>0){
            System.out.println(discount);
        }
        else{
            System.out.println(0);
        }

    }
}
