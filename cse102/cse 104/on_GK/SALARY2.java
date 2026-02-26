
import java.util.Scanner;

public class SALARY2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        double work_hour =0;
        double add_hour=0;
        double sum_work_hour=0;
        double sum_add_hour=0;
        double sum_money_work=0;
        double sum_money_add=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                double hours = sc.nextDouble();
                if(hours<8){
                    work_hour+=hours;
                }
                else{
                    work_hour+=8;
                    add_hour+=hours-8;
                }
            }
            double cost =sc.nextDouble();
            sum_work_hour+=work_hour;
            sum_add_hour+=add_hour;
            sum_money_work+=work_hour*cost;
            sum_money_add+=add_hour*1.5*cost;
            double total=(work_hour+add_hour*1.5)*cost;
            System.out.printf("%.2f\n",total);
            work_hour=add_hour=0;
        }
        System.out.printf("%.2f\n",sum_work_hour==0?0.0:sum_money_work/sum_work_hour);
        System.out.printf("%.2f\n",sum_money_add==0?0.0:sum_money_add/sum_add_hour);
    }
}
