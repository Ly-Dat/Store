
import java.util.Arrays;
import java.util.Scanner;

public class EIULOGFILE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
        for(int i=0; i<m; i++){
            int a = Arrays.binarySearch(arr, sc.nextLong());
            if(a<0){
                a= -a-1;
            }
            sb.append(a > n-1 ? "-1" : arr[a]).append(" ");
        }
        System.out.println(sb);
    }
}
