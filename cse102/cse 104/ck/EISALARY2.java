
import java.util.Scanner;

public class EISALARY2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int worker = sc.nextInt();
        double sum_mwh =0;
        double sum_mah =0;
        double sum_wh =0;
        double sum_ah =0;
        for(int i=0; i<worker; i++){
            double wh =0;
            double ah =0;
            for(int j=0; j<5; j++){
                double hour = sc.nextDouble();
                wh+= Math.min(hour,8);
                ah+= Math.max(hour-8,0);
            }
            double cost = sc.nextDouble();
            sum_wh += wh;
            sum_ah += ah;
            sum_mwh += wh*cost;
            sum_mah += ah*cost*1.5;
            double total = wh*cost+ah*cost*1.5;
            System.out.printf("%.2f\n", total);
        }
        System.out.printf("%.2f\n", sum_wh==0?0.0:sum_mwh/sum_wh);
        System.out.printf("%.2f\n", sum_ah==0?0.0:sum_mah/sum_ah);
    }
}
