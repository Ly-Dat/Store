
import java.util.Scanner;

public class c11_EIPURCHASE3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long pay_now = sc.nextLong();
        int month = sc.nextInt();
        double rate = sc.nextDouble();
        double eachMonth = (money-pay_now)*rate/(1-Math.pow(1+rate,-month));
        System.out.println((long) eachMonth);
    }
}