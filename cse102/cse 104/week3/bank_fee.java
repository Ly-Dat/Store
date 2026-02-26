
import java.util.Scanner;

public class bank_fee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        long sec = sc.nextLong();
        double fee=0;
        if(money<500){
            fee+=12.0+0.2*sec;
        }
        else if(money<2000){
            fee+=7.5+0.2*sec;
        }
        else if(money<5000){
            fee+=5.0+0.1*sec;
        }
        else{
            fee=0;
        }
        System.out.printf("%.2f",fee);
    }
}
