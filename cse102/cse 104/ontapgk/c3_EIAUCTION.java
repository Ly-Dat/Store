
import java.util.Scanner;

public class c3_EIAUCTION {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_roll = sc.nextInt();
        int[] xx = new int[7];
        int[] point = new int[num_roll];
        int vt=0;
        for(int i=0; i<num_roll; i++){
            point[i]=sc.nextInt();
            xx[point[i]]+=1;
        }
        for(int i=6; i>=1; i--){
            if(xx[i]==1){
                vt=i;
                break;
            }
        }
        for(int i=0; i<num_roll; i++){
            if(point[i]==vt){
                vt=i+1;
                break;
            }
        }
        if(vt==0){
            System.out.println("none");
        }
        else{
            System.out.println(vt);
        }
    }
}