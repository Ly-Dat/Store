
import java.util.Scanner;

public class Grade_PAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int count=0;
        long sum=0;
        for(int i=0; i<T; i++){
            long point = sc.nextLong();
            if(point>=50){
                sum+=point;
                count++;
            }
        }
        System.out.println(Math.round((double)sum/count));
    }
}
