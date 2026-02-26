import java.util.Scanner;

public class EIUPURCHASE3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money_item = sc.nextLong();
        long pay_now=sc.nextLong();
        int num_month=sc.nextInt();
        double rate=sc.nextDouble();
        double money_eachMonth = (money_item-pay_now)*rate/(1-Math.pow(1+rate, -num_month));
        System.out.println((long)Math.floor(money_eachMonth));
    }
}
