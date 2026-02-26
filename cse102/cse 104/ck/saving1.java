import java.util.Scanner;

public class saving1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rate={0, 3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};
        double money = sc.nextLong();
        int month = sc.nextInt();
        int year = month/12;
        month%=12;
        money*=Math.pow(1.0692,year);
        money*=(1+rate[month]*month/1200);
        System.out.println(Math.round(money));
    }
}
