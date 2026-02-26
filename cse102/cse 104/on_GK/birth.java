
import java.util.Scanner;

public class birth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            long Q_blue=sc.nextLong();
            long Q_red=sc.nextLong();
            long cost_blue= sc.nextLong();
            long cost_red=sc.nextLong();
            long cost_trade=sc.nextLong();
            long pay=0;
            if(cost_blue+cost_trade<cost_red){
                pay=(Q_blue+Q_red)*cost_blue+Q_red*cost_trade;
            }
            else if(cost_red+cost_trade<cost_blue){
                pay=(Q_blue+Q_red)*cost_red+Q_blue*cost_trade;
            }
            else{
                pay=Q_blue*cost_blue+Q_red*cost_red;
            }
            System.out.println(pay);
        }
    }
}
