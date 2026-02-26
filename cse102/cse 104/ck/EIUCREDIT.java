
import java.util.Scanner;

public class EIUCREDIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tescase = sc.nextInt();
        double rate = sc.nextDouble();
        int time = sc.nextInt();
        double sum=0;
        double debt=0;
        double[] bank = new double[time+1];
        for(int i=0; i<tescase; i++){
            int day = sc.nextInt();
            bank[day]+=sc.nextDouble();
        }
        for(int i=1; i<=time; i++){
            if(sum<0){
                debt+=sum;
            }
            sum+=bank[i];
            if(i%30==1){
                sum+=debt*rate/30;
                debt=0;
            }
        }
        System.out.println((long)sum);
    }
}
