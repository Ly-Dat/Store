
import java.util.Scanner;

public class EIDINRATE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tescase = sc.nextInt();
        for (int i = 0; i < tescase; i++) {
            double money = sc.nextDouble();
            double rate = sc.nextDouble();
            double gain = sc.nextDouble();
            double year = Math.log(gain / money) / Math.log(1 + rate / 100);
            System.out.println((long)Math.ceil(year));
        }

    }
}
