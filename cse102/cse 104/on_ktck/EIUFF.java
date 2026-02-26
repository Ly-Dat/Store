
import java.util.Scanner;


public class EIUFF {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double r= sc.nextDouble()/100;
        double f=sc.nextDouble()/100;
        long withdraw = sc.nextLong();
        long month = sc.nextLong();
        double a = (1+f)/(1+r);
        double money = withdraw*(1-Math.pow(a,month-1))/(r-f);
        System.out.printf("%.4f",money);
    }
}
