import java.util.Scanner;

public class GROSS2 {
    public static void main(String[] args) {
        long[] arr_money = {0, 5000000, 10000000, 18000000, 32000000, 52000000, 80000000, Long.MAX_VALUE};
        double[] rate = {0, 0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35};
        Scanner sc = new Scanner(System.in);
        double money_pay = sc.nextDouble();
        money_pay-=11000000;
        for(int i=1; i<arr_money.length; i++){
            // ct: (money-arr[i-1])*rate[i]=discount; money = moneyPay+discount
            if(money_pay>arr_money[i-1]){
                money_pay +=Math.min((arr_money[i]-arr_money[i-1])*rate[i], (arr_money[i-1]-money_pay)*rate[i]/(rate[i]-1));
            }
        }
        
        System.out.println(11000000+(long)Math.round(money_pay));
    }
}
