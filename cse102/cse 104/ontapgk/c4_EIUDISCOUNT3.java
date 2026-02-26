import java.util.Scanner;

public class c4_EIUDISCOUNT3 {
    public static void main(String[] args) {
        long[] arr_money = {5000000, 20000000, 100000000, 300000000, 600000000, 900000000, Long.MAX_VALUE};
        double[] rate = {0, 0.03, 0.05, 0.07, 0.1, 0.12, 0.15};
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        int count=0;
        for(int i=0; i<3; i++){
            int voucher=sc.nextInt();
            count+=voucher;
        }
        long discount = 0;
        for(int i=1; i<arr_money.length; i++){
            if(money>arr_money[i-1]){
                discount += Math.min(arr_money[i]-arr_money[i-1], money-arr_money[i-1])*rate[i];
            }    
        }
        long pay = money-discount;
        for(int i=0; i<count; i++){
        	pay*=0.98;
        }
        System.out.println(pay);
    }
}
