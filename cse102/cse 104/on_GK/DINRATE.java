
import java.util.Scanner;

public class DINRATE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            double money = sc.nextDouble();
            double rate = sc.nextDouble();
            double gain = sc.nextDouble();
            double year = Math.log(gain/money)/Math.log(1+rate/100);
            System.out.println((long)Math.ceil(year));
        }
    }
}
