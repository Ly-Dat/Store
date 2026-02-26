
import java.util.Scanner;

public class Subarray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length_sub = sc.nextInt();
        long max_sum=0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        for(int j=0; j<length_sub; j++){
            max_sum+=arr[j];
        }
        for(int i =0; i<arr.length-length_sub; i++){
            if(max_sum-arr[i]+arr[i+length_sub]>max_sum){
                max_sum=max_sum-arr[i]+arr[i+length_sub];
            }
        }
        System.out.println(max_sum);
    }
}
