import java.util.Scanner;

public class saving3 {
    static double findsum(double[] rate, double money, int month, double mid){
        double sum=0;
        for(int i=0; i<month; i++){
            int cur_month=month-i;
            int year=cur_month/12;
            cur_month%=12;
            sum+=mid*Math.pow(1.0692,year)*(1+rate[cur_month]*cur_month/1200);
        }
        return sum-money;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rate = {0, 3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92};
        double money = sc.nextDouble();
        int month = sc.nextInt();

        double left =0;
        double right = Long.MAX_VALUE;
        double round = 1e-5;
        double mid=0;

        while(right-left>round){
            mid=(right+left)/2;
            double sum= findsum(rate, money, month, mid);
            if(sum>0){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        System.out.printf("%.4f",mid);
    }
}
