import java.util.Scanner;

public class CREDIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gd = sc.nextInt();
        double rate = sc.nextDouble();
        int num_day = sc.nextInt();
        double[] bank= new double[num_day+1];
        double sum_money=0;
        double debt =0;
        for(int i=0; i<gd; i++){
            int day = sc.nextInt();
            double money = sc.nextDouble();
            bank[day]+=money;
        }
        for(int j=1; j<=num_day; j++){
            if(sum_money<0){
                debt+=sum_money;
            }
            sum_money+=bank[j];
            if(j%30==1){
                sum_money+=debt*rate/30;
                debt=0;
            }
        }
        System.out.println(sum_money);
    }
}
