import java.util.Scanner;

public class c5_EIMEMCARD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long[] value = {0, 1000000, 20000000, 50000000, 200000000};
        double[] rate = {0, 0.02, 0.03, 0.05, 0.07};
        int items = sc.nextInt();
        double sum_money = 0;
        int rank=0;
        for(int i=0; i<items; i++){
            long money = sc.nextLong();
            double discount = money*rate[rank];
            sb.append(discount+" ");
            sum_money+=money;
            while (true) {
                if (sum_money >= value[rank + 1]) {
                    rank++;
                } else {
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
