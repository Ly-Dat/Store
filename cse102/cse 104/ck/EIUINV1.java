
import java.util.Scanner;

public class EIUINV1 {
    static double findrate(long[] arr,double rate, double money){
        double sum = 0;
        for(int i=0; i<12; i++){
            sum+=arr[i]*Math.pow(1+rate,11-i);
        }
        return sum-money;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        long[] array_money = new long[12];
        for(int i=0; i<12; i++){
            array_money[i]=sc.nextLong();
        }

        double left = 0.0;
        double right = 1;
        double round = 1e-5;
        double rate = 0;

        while(right-left>round){
            rate = (right+left)/2;
            double frate = findrate(array_money, rate, money);
            if(frate>0){
                right=rate;
            }
            else{
                left=rate;
            }
        }
        System.out.printf("%.3f", rate);
    }
}
