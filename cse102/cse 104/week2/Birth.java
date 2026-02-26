
import java.util.Scanner;

public class Birth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long Q_red = sc.nextLong();
            long Q_blue = sc.nextLong();
            long moneyOfRed = sc.nextLong();
            long moneyOfBlue = sc.nextLong();
            long moneyTrade = sc.nextLong();
            long sum_money;
            if (moneyOfRed > moneyOfBlue + moneyTrade) {
                sum_money = (Q_blue + Q_red) * moneyOfBlue + Q_red * moneyTrade;
            } else if (moneyOfBlue > moneyOfRed + moneyTrade) {
                sum_money = (Q_blue + Q_red) * moneyOfRed + Q_blue * moneyTrade;
            } else {
                sum_money = Q_blue * moneyOfBlue + Q_red * moneyOfRed;
            }
            System.out.println(sum_money);
        }
    }
}
