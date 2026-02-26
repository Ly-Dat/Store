
import java.util.Scanner;

public class INCRDES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr_num = new int[n];
        int count_incr = 1;
        int count_decr = 1;
        for(int i = 0; i<n; i++){
            arr_num[i] = sc.nextInt();
        }
        for(int j=1; j<n; j++){
            if(arr_num[j]>arr_num[j-1]){
                count_incr++;
            }
            else if(arr_num[j]<arr_num[j-1]){
                count_decr++;
            }
        }
        if(count_incr==n){
            System.out.println("increasing");
        }
        else if(count_decr==n){
            System.out.println("decreasing");
        }
        else{
            System.out.println("none");
        }
    }
}
