
import java.util.Scanner;

public class cau3 {
    static double findMoney (double r, double f, long withdraw, long month, double x){
        for(int i=0; i<month-1; i++){
            x= x*(1+r) - withdraw*Math.pow(1+f,i);
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble()/100;
        double f = sc.nextDouble()/100;
        long withdraw = sc.nextLong();
        long month = sc.nextLong();

        double left=0;
        double right = Long.MAX_VALUE;
        double mid = 0;
        double round = 1e-5;

        while(right-left>round){
            mid=(right+left)/2;
            double fmid = findMoney(r, f, withdraw, month, mid);
            if(fmid>0){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        System.out.printf("%.4f", mid);
    }
}
