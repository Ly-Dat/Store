import java.util.Arrays;
import java.util.Scanner;

public class EIUCHRMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] value = {2000000, 5000000, 10000000, 20000000, 50000000, 100000000, 200000000, Long.MAX_VALUE};
        double[] rate={0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.1};
        int T = sc.nextInt();
        long[] money= new long[T];
        long total=0;
        for(int i=0; i<T; i++){
            money[i]=sc.nextLong();
            total+=money[i];
        }
        Arrays.sort(money);
        int j=0;
        double discount=0;
        for(int i=0; i<T; i++){
            if(money[i]>value[j]){
                j++;
                i--;
            }
            else{
                discount+=money[i]*rate[j];
            }
        }
        System.out.println(Math.round(total-discount));
        
    }
}
