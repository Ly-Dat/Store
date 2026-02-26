import java.util.Scanner;

public class EIBANKLOAN3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        double cost_car= sc.nextDouble();
        long pay_max= sc.nextLong();
        int month = sc.nextInt();
        double rate = sc.nextDouble()/1200;
        double fee = sc.nextDouble()/100;

        double a= cost_car/month;
        double total = 0;

        for(int i=1; i<=month; i++){
            if(cost_car<0){
                break;
            }
            double re = Math.max(a*i-total,0);
            double pa = (pay_max-cost_car*rate-re)/(1+fee);
            cost_car-=re+pa;
            sb.append(i+" "+Math.round(Math.max(cost_car,0))+"\n");
            total+=re+pa;
        }
        System.out.println(sb);
    }
}