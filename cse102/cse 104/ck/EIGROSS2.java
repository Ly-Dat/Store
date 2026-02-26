
import java.util.Scanner;

public class EIGROSS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mil = 1000000;
        long[] arr_money={0, 5*mil, 10*mil, 18*mil, 32*mil, 52*mil, 80*mil, Long.MAX_VALUE};
        double[] rate = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35};
        double money=sc.nextLong();
        money-=11*mil;
        for(int i=1; i<arr_money.length; i++){
            if(money>arr_money[i-1]){
                money+=Math.min((money-arr_money[i-1])/(1-rate[i-1]), arr_money[i]-arr_money[i-1])*rate[i-1];
            }
        }
        System.out.println(11*mil+Math.round(money));
    }
}
