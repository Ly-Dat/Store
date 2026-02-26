import java.util.Scanner;

public class EIUDISCOUNT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mil = 1000000;
        long[] arr_money = {5*mil, 20*mil, 100*mil, 300*mil, 600*mil, 900*mil, Long.MAX_VALUE};
        double[] rate = {0, 0.03, 0.05, 0.07, 0.1, 0.12, 0.15};
        long money=sc.nextLong();
        long discount=0;
        for(int i=1; i<arr_money.length; i++){
            if(money>arr_money[i-1]){
                discount+=Math.min(money-arr_money[i-1], arr_money[i]-arr_money[i-1])*rate[i];
            }
        }
        long pay = money-discount;
        for(int i=0; i<3; i++){
            int voucher = sc.nextInt();
            if(voucher==1){
                pay*=0.98;
            }
        }
        System.out.println(pay);
    }
}
