
import java.util.Scanner;

public class Buy_computers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double rate = sc.nextDouble();
        double money_inBank = 0;
        for(int i=0; i<12; i++){
            long money = sc.nextLong();
            money_inBank+=money;
            money_inBank*=(1+rate);
            
        }
        System.out.println(Math.round(money_inBank));
    }
}
