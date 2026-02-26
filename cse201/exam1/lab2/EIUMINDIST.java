
import java.util.Arrays;
import java.util.Scanner;

public class EIUMINDIST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[N - 1] - arr[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int lastSelected = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] - lastSelected >= mid) {
                    count++;
                    lastSelected = arr[i];
                    if (count == K) {
                        break;
                    }
                }
            }

            if (count == K) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}
