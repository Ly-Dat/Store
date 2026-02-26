
import java.util.Scanner;

public class c7_EIUBHOUSE {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        long cost_house = sc.nextLong();
        long borrow = sc.nextLong();
        int month = sc.nextInt();
        double rate = sc.nextDouble()/100;
        double money_borrow = cost_house-borrow;
        double money_eachMonth = money_borrow/month;
        for(int i=0; i<month; i++){
            double pay = money_eachMonth + money_borrow*rate;
            sb.append((i+1)+" "+Math.round(pay)+"\n");
            money_borrow -= money_eachMonth;
        }
        System.out.println(sb);
    }
}
