
import java.util.Scanner;

public class SALARY2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum_hour_work = 0;
        double sum_hour_add = 0;
        double sum_money_work = 0;
        double sum_money_add = 0;
        double hour_add = 0;
        double hour_work = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                double hours = sc.nextDouble();
                if (hours < 8) {
                    hour_work += hours;
                } else {
                    hour_work += 8;
                    hour_add += hours - 8;
                }
            }
            double money_hour = sc.nextDouble();
            sum_hour_work += hour_work;
            sum_hour_add += hour_add;
            sum_money_work += hour_work * money_hour;
            sum_money_add += hour_add * money_hour * 1.5;
            double salary = (hour_work + hour_add * 1.5) * money_hour;
            System.out.printf("%.2f\n", salary);
            hour_work = 0;
            hour_add = 0;
        }
        if(sum_hour_work!=0){
            System.out.printf("%.2f\n", sum_money_work / sum_hour_work);
        }
        else{
            System.out.println(0.0);
        }
        if(sum_hour_add!=0){
            System.out.printf("%.2f\n", sum_money_add / sum_hour_add);
        }
        else{
            System.out.println(0.0);
        }
        
    }
}
