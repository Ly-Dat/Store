
import java.util.Scanner;

public class EIUMARKUP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        int i=0;
        long pay =0;
        while(true){
            if(i==21){
                i=20;
            }
            if(money>100){
                money-=100;
                pay+=100*(200-i);
                i++;
            }
            else{
                pay+=money*(200-i);
                break;
            }
        }
        System.out.println(pay);
    }
}
