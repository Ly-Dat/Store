
import java.util.Scanner;

public class EIMEMCARD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int mil = 1000000;
        long[] arr_money = {0, 1*mil, 20*mil, 50*mil, 200*mil, Long.MAX_VALUE};
        double[] rate = {0, 0.02, 0.03, 0.05, 0.07};
        int n = sc.nextInt();
        long sum = 0;
        int rank=0;
        for(int i=0; i<n; i++){
            long money = sc.nextLong();
            sum+=money;
            double discount =money*rate[rank];
            sb.append(discount+" ");
            while (true) { 
                if(sum>=arr_money[rank+1]){
                    rank++;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
