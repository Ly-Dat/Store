
import java.util.Scanner;

public class Retirement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        double interest_rate = sc.nextDouble()/100;
        double inflation_rate = sc.nextDouble()/100;
        long[] arr_money = new long[month];
        for(int i=0; i<month; i++){
            arr_money[i] = sc.nextLong();
        }

        double bank=0;
        double rate1=0;
        for(int i=0; i<month; i++){
            bank+=arr_money[i];
            bank*=(1+interest_rate);
            rate1+=Math.pow((1+inflation_rate), i)*Math.pow((1+interest_rate), month-i);
        }
        double rate2=rate1;
        for(int j= month; j<1200; j++){
            rate2+=Math.pow((1+inflation_rate), j)*Math.pow((1+interest_rate), month-j);
        }
        double x = bank*Math.pow((1+interest_rate),1200-1-month)/(rate1*Math.pow((1+interest_rate),1200-1-month)+rate2);
        System.out.println(Math.round(x));
    }
}
