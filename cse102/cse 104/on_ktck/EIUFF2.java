import java.util.Scanner;

public class EIUFF2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double r= sc.nextDouble()/100;
        double f=sc.nextDouble()/100;
        long withdraw = sc.nextLong();
        double money = withdraw/(r-f);
        System.out.println((long)Math.ceil(money));
    }
}
