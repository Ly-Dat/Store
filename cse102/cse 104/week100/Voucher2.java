
import java.util.Scanner;

public class Voucher2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long pay=0;
        long discount=0;
        long max_discount=0;
        for(int i=0; i<T; i++){
            long money=sc.nextLong();
            pay+=money;
            discount =(long)(money*0.3);
            if(discount>max_discount){
                max_discount=discount;
            }
        }
        if(max_discount<50000){
            System.out.println(pay-max_discount);
        }
        else{
            System.out.println(pay-50000);
        }
    }
}
