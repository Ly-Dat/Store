
import java.util.Scanner;

public class SNAIL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long v = sc.nextLong();
        double up=a-b;
        double day= Math.ceil((v-a)/up);
        System.out.println((long)day+1);
        
    }
}
