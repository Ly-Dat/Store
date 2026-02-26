import java.util.Scanner;

public class EIUBHOUSE {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        double house_cost=sc.nextDouble();
        double can_borrow = sc.nextDouble();
        int num_months=sc.nextInt();
        double rate= sc.nextDouble();
        rate=rate/100;
        double money_vay = house_cost-can_borrow;
        double money_eachMonth= money_vay/num_months;
        for (long i = 1; i <= num_months; i++) {
            double pay = money_eachMonth + money_vay * rate;
            sb.append(i + " " +(long)Math.round(pay) + "\n");
            money_vay -= money_eachMonth;
        }
        System.out.println(sb);
    }
}
