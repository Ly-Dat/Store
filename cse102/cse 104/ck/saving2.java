
import java.util.Scanner;

public class saving2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rate={0, 3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};
        int month = sc.nextInt();
        double sum=0;
        for(int i=0; i<month; i++){
            double money = sc.nextLong();
            int cur_month= month-i;
            int year=cur_month/12;
            cur_month%=12;
            money*=Math.pow(1.0692,year);
            money*=(1+rate[cur_month]*cur_month/1200);
            sum+=money;
        }
        System.out.println(Math.round(sum));
    }
}
