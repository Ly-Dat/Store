import java.util.Scanner;

public class EIUTAX2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mil=1000000;
        long[] arr_money = {0, 5*mil, 10*mil, 18*mil, 32*mil, 52*mil, 80*mil, Long.MAX_VALUE};
        double[] rate = {5, 10, 15, 20, 25, 30, 35};
        long money=sc.nextLong()-11*mil;
        long discount=0;
        for(int i=1; i<arr_money.length; i++){
            if(money>arr_money[i-1]){
                discount+=Math.min(money-arr_money[i-1], arr_money[i]-arr_money[i-1])*rate[i-1]/100;
            }
        }
        System.out.println(discount);
    }
}
