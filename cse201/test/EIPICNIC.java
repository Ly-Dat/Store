
import java.util.Scanner;

public class EIPICNIC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_group = sc.nextInt();
        int[] car = new int[5];
        int result=0;
        for(int i=0; i<num_group; i++){
            car[sc.nextInt()]++;
        }
        // nhom 4
        result+=car[4];
        // nhom 3 1
        int a =Math.min(car[3],car[1]);
        result+=car[3];
        car[1]-=a;
        // nhom 2 2
        result+=car[2]/2;
        // nhom 2 1
        if (car[2] % 2 == 1) {
            result += 1;
            car[1] -= Math.min(2, car[1]);
        }
        // nhom 1
        result+=Math.ceil((double)car[1]/4);
        System.out.println(result);
    }
}
