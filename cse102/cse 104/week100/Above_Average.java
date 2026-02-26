
import java.util.Arrays;
import java.util.Scanner;

public class Above_Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        long total=0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            total+=arr[i];
        }
        double aver= (double)total/n;
        int count=0;
        Arrays.sort(arr);
        for(int j=n-1; j>=0; j--){
            if(arr[j]<=aver){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
