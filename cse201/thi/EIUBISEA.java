
import java.util.Arrays;
import java.util.Scanner;

public class EIUBISEA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int result = binarySearch(arr,0,n-1, a);
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }
    static int binarySearch(int arr[], int left, int right, int number) {
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == number) {
                index = mid;
                right = mid - 1;
            } else if (arr[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
