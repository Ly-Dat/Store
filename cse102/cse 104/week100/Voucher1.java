
import java.util.Scanner;

public class Voucher1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        long discount =(long)(money*0.3);
        if(discount<50000){
            System.out.println(money-discount);
        }
        else{
            System.out.println(money-50000);
        }

    }
}
