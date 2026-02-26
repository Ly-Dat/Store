import java.util.Scanner;

public class Bank_Loan2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb =  new StringBuilder();

        double money = sc.nextLong();
        double max_pay = sc.nextDouble();
        int month = sc.nextInt();
        double rate=sc.nextDouble()/1200;
        double fee=sc.nextDouble()/100;

        double month_pay=money/month;
        double total=0;
        for(int i=1; i<=month; i++){
            if(money<0){
                break;
            }
            double required = Math.max(month_pay*i-total,0);
            double pay_afterFee=max_pay-money*rate-required;
            double pay_fee=pay_afterFee/(1+fee);
            money-=pay_fee+required;
            sb.append(i+" "+Math.round(Math.max(money,0))+"\n");
            total+=pay_fee+required;
        }
        System.out.println(sb);

    }
}
