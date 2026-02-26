
import java.util.Scanner;

public class SNAIL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long V = sc.nextLong();
        double up=A-B;
        double day = Math.ceil(((V-A)/up+1)) ;
        System.out.println((int)day);

    }
}
