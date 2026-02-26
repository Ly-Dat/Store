import java.util.Scanner;

public class EIDISCOU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mil = 1000000;
        long[] arr_money = {1*mil, 2*mil, 10*mil, 50*mil, 100*mil, 200*mil, 500*mil, Long.MAX_VALUE};
        double[] rate = {0, 0.03, 0.05, 0.07, 0.1, 0.12, 0.15};
        long money = sc.nextLong();
        long discount = 0 ;
        for(int i=1; i<arr_money.length; i++){
            if(money>arr_money[i-1]){
                discount+=Math.min(money-arr_money[i-1], arr_money[i]-arr_money[i-1])*rate[i-1];
            }
        }
        System.out.println(money-discount);
    }
}