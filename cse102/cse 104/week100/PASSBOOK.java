
import java.util.Scanner;

public class PASSBOOK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        int month_bank = sc.nextInt();
        int month_loan = sc.nextInt();
        double rate_bank=sc.nextDouble()/100;
        double rate_loan=sc.nextDouble()/100;
        int year = (month_bank-month_loan)/12;
        int month = (month_bank-month_loan)%12;
        double money_loan = money*(1+rate_bank*month_bank/12)/Math.pow((1+rate_loan),year)/(1+rate_loan*(month)/12);
        System.out.println(Math.max(Math.round(money_loan),money));
    }
}
