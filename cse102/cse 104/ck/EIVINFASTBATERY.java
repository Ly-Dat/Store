
import java.util.Scanner;

public class EIVINFASTBATERY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long pay_now = sc.nextLong();
        int month = sc.nextInt();
        double rate = sc.nextDouble()/100;

        double pay = (money-pay_now)*rate/(1-Math.pow(1+rate,-month));
        pay+= pay_now*rate;
        System.out.println(Math.round(pay));
    }
}
