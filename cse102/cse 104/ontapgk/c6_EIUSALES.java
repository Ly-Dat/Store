
import java.util.Scanner;

public class c6_EIUSALES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] ds={0, 20, 50, 200, 500, 2000, Long.MAX_VALUE};
        double[] rate = {0.02, 0.03, 0.04, 0.05, 0.06, 0.07};
        long money = sc.nextLong();
        double discount=0;
        for(int i=1; i<ds.length; i++){
            if(money>ds[i-1]){
                discount+=Math.min(ds[i]-ds[i-1], money-ds[i-1])*rate[i-1];
            }
        }
        System.out.println(discount);
    }
}
