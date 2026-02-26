
import java.util.Scanner;

public class EIURETIRE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        double in_rate = sc.nextDouble()/1200;
        double inflation =sc.nextDouble()/1200;
        double bank = 0;
        double rate = 0;
        for(int i=0; i<month; i++){
            bank+=sc.nextDouble()*Math.pow(1+in_rate,1199-i);
        }
        for(int i=0; i<1200; i++){
            rate+=Math.pow(1+in_rate,1199-i)*Math.pow(1+inflation,i);
        }
        System.out.println((long)(bank/rate));
    }
}
