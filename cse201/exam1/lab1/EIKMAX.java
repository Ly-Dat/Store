
import java.util.Arrays;
import java.util.Scanner;

public class EIKMAX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int j=0; j<k; j++){
            sb.append(arr[n-j-1]+" ");
        }
        System.out.println(sb);
    }
}
