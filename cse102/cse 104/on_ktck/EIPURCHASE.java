
import java.util.Scanner;

public class EIPURCHASE {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long money = sc.nextLong();
        int month = sc.nextInt();
        long pay_now = sc.nextLong();
        long pay_eachMoth = sc.nextLong();

        double rate=0;
        double left = 0;
        double right = 1.0;
        double midle = 1e-6;

        while(right-left>midle){
            rate=(right+left)/2;
            double frate = (money-pay_now)*rate/(1-Math.pow(1+rate,-month))-pay_eachMoth;
            if(frate>0){
                right=rate;
            }
            else{
                left=rate;
            }
        }
        System.out.println(rate);
    }
}
