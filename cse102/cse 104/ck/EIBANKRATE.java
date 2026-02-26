
import java.util.Scanner;

public class EIBANKRATE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = sc.nextLong();
        double month = sc.nextInt();
        money*=(1+9*month/1200);
        System.out.println(money);
    }
}
