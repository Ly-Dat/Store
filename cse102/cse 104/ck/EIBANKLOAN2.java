
import java.util.Scanner;

public class EIBANKLOAN2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long pay_max = sc.nextLong();
        double rate = sc.nextDouble()/1200;
        double month = Math.log(pay_max/(pay_max-money*rate))/Math.log(1+rate);
        System.out.println((long)Math.ceil(month));
    }
}
