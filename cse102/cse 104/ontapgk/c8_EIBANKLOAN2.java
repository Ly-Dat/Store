
import java.util.Scanner;

public class c8_EIBANKLOAN2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long eachMonth = sc.nextLong();
        double rate = sc.nextDouble()/1200;
        int month =(int)Math.ceil(Math.log(eachMonth/(eachMonth-money*rate))/Math.log(1+rate));
        System.out.println(month);
    }
}