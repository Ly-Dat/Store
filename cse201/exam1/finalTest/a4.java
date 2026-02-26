
import java.util.Arrays;
import java.util.Scanner;

public class a4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int total = -1;
        int min = -1;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum <= money) {
                if (sum > total) {
                    total = sum;
                    min = arr[right] - arr[left];
                } else if (sum == total) {
                    min = arr[right] - arr[left];
                }
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println(total+" "+min);
    }
}
