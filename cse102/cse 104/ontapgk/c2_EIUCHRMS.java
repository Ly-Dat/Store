
import java.util.Scanner;

public class c2_EIUCHRMS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] value = {2000000, 5000000, 10000000, 20000000, 50000000, 100000000, 200000000};
        double[] rate={0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09};
        int num_bill = sc.nextInt();
        long total=0;
        double discount = 0;
        for(int i =0; i<num_bill; i++){
            long money = sc.nextLong();
            total+=money;
            if(money>200000000){
                discount+=money*0.1;
            }
            else{
                for(int j= 0; j<value.length; j++){
                    if(money<=value[j]){
                        discount+=money*rate[j];
                        break;
                    }
                }
            }
        }
        System.out.println(Math.round(total-discount));
    }
}