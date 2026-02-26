
import java.util.Scanner;

public class EIUPASSBOOK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        int month_bank = sc.nextInt();
        int month =month_bank-sc.nextInt();
        double rate_bank = sc.nextDouble()/100;
        double rate = sc.nextDouble()/100;
        int year=month/12;
        month%=12;
        double loan = money * (1+rate_bank*month_bank/12)/Math.pow(1+rate,year)/(1+rate*month/12);
        System.out.println(Math.max(Math.round(loan), money));
    }
}
