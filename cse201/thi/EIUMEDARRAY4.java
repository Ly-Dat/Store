
import java.util.Scanner;

public class EIUMEDARRAY4 {

    static long result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            int N = sc.nextInt();
            long[] arr = new long[N];
            long A = sc.nextInt();
            long P = sc.nextLong();
            int k = sc.nextInt();
            arr[0] = (A * A) % P;
            for (int j = 1; j < N; j++) {
                arr[j] = (arr[j - 1] * A) % P;
            }
            quickSort(arr, 0, N, k);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void quickSort(long[] arr, int left, int right, int k) {
        int mid = divide(arr, left, right);
        if (mid > k - 1) {
            quickSort(arr, left, mid, k);
        } else if (mid < k - 1) {
            quickSort(arr, mid + 1, right, k);
        } else {
            result = arr[mid];
            return;
        }
    }

    static int divide(long[] arr, int left, int right) {
        int mid = left;
        long pivot = arr[left];
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, mid + 1, i);
                mid++;
            }
        }
        swap(arr, mid, left);
        return mid;
    }

    static void swap(long[] arr, int i, int j) {
        long t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
