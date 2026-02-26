
import java.util.Arrays;
import java.util.Scanner;

public class Voucher3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int voucher = sc.nextInt();
        long sum_discount=0;
        long pay=0;
        long[] discount= new long[T];
        for(int i=0; i<T; i++){
            long money=sc.nextLong();
            pay+=money;
            discount[i] =(long)(money*0.3);
            if(discount[i]>50000){
                discount[i]=50000;
            }
        }
        Arrays.sort(discount);
        if(voucher>T){
            voucher=T;
        }
        for(int j=T-1; j>=T-voucher; j--){
            sum_discount+=discount[j];
        }
        System.out.println(pay-sum_discount);
    }
}
