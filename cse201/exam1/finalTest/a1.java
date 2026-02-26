
import java.util.Scanner;

public class a1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] car = new int[5];
        for(int i=0; i<n; i++){
            car[sc.nextInt()]++;
        }
        int result = 0;
        //4
        result+=car[4];
        // 3 1
        result+=car[3];
        car[1]-=Math.min(car[3], car[1]);
        // 2 2
        result+=car[2]/2;
        // 2 1
        if(car[2]%2==1){
            result++;
            car[1]-=Math.min(2,car[1]);
        }
        // 1 1
        result+=Math.ceil((double)car[1]/4);
        System.out.println(result);
    }
}