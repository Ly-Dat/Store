
import java.util.Scanner;

public class BANKFEE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] arr_money={500, 2000, 5000, Long.MAX_VALUE};
        double[] fee = {12.00, 7.50, 5.00, 0};
        double[] check= {0.20, 0.20, 0.10, 0.00};
        int n=sc.nextInt();
        double pay=0;
        double sum=0;
        double sum_sec=0;
        for(int i=0; i<n; i++){
            double money = sc.nextDouble();
            long sec=sc.nextLong();
            sum_sec+=sec;
            for(int j=0; j<arr_money.length; j++){
                if(money<arr_money[j]){
                    pay=fee[j]+sec*check[j];
                    break;
                }
            }
            sum+=pay;
        }
        System.out.printf("%.2f",sum/sum_sec);
    }
}
