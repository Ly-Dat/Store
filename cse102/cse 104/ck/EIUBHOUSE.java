
import java.util.Scanner;

public class EIUBHOUSE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        double cost_house = sc.nextDouble();
        double borrow = sc.nextLong();
        int month = sc.nextInt();
        double rate = sc.nextDouble()/100;

        borrow= cost_house-borrow;
        double me=borrow/month;
        
        for(int i=0; i<month; i++){
            double pay = me+borrow*rate;
            borrow-=me;
            sb.append(i+1+" "+Math.round(pay)+"\n");
        }
        System.out.println(sb);
    }
}
