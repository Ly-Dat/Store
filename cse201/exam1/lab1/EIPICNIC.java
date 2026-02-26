
import java.util.Scanner;

public class EIPICNIC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] car = new int[5];
        for(int i=0; i<n; i++){
            car[sc.nextInt()]++;
        }
        int numCar=0;
        // 4
        numCar+=car[4];
        // 3 1
        numCar+=car[3];
        car[1]-=Math.min(car[3], car[1]);
        // 2 2
        numCar += car[2]/2;
        // 2 1
        if(car[2]%2==1){
            numCar+=1;
            car[1]-=Math.min(2, car[1]);
        }
        // 1
        numCar+=Math.ceil((double)car[1]/4);
        System.out.println(numCar);
    }
}
